package com.liudonghua.tutorials.spring_websocket.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.liudonghua.tutorials.spring_websocket.dto.IdeaDto;
import com.liudonghua.tutorials.spring_websocket.model.Idea;
import com.liudonghua.tutorials.spring_websocket.repository.IdeaRepository;
import com.liudonghua.tutorials.spring_websocket.service.IdeaService;

@Service
public class IdeaServiceImpl implements IdeaService {

  @Autowired
  private IdeaRepository repo;

  @Autowired
  private Mapper mapper;

  public List getIdeas() {
    List<IdeaDto> list = repo.findAll();
    List<Idea> out = new ArrayList<>();
    for (IdeaDto dto : list) {
      out.add(mapper.map(dto, Idea.class));
    }
    return out;
  }

  @Transactional
  @Override
  public Idea addIdea(Idea idea) {
    IdeaDto dto = mapper.map(idea, IdeaDto.class);
    return mapper.map(repo.saveAndFlush(dto), Idea.class);
  }

  @Transactional
  @Override
  public Idea updateIdea(Idea idea) {
    IdeaDto dto = repo.findOne(idea.getId());
    dto.setDescription(idea.getDescription());
    dto.setTitle(idea.getTitle());
    dto.setVotes(idea.getVotes());
    return mapper.map(repo.saveAndFlush(dto), Idea.class);
  }

  @Transactional
  @Override
  public void deleteIdea(Idea idea) {
    repo.delete(idea.getId());
  }
}
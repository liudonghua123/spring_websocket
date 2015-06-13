package com.liudonghua.tutorials.spring_websocket.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.liudonghua.tutorials.spring_websocket.model.Idea;

public interface IdeaService {

  public List getIdeas();

  @Transactional
  public Idea addIdea(Idea idea);

  @Transactional
  public Idea updateIdea(Idea idea);

  @Transactional
  public void deleteIdea(Idea idea);
}
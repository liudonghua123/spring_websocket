package com.liudonghua.tutorials.spring_websocket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.liudonghua.tutorials.spring_websocket.dto.IdeaDto;

public interface IdeaRepository  extends JpaRepository<IdeaDto, Integer> {

}
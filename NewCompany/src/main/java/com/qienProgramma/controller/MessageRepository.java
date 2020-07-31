package com.qienProgramma.controller;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import com.qienProgramma.model.Messages;

@Component
public interface MessageRepository extends CrudRepository<Messages, Long>  {

}

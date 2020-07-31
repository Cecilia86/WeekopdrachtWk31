package com.qienProgramma.controller;

import com.qienProgramma.model.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface DepManagerRepository extends CrudRepository<DepManager, Long> {
}

package com.qienProgramma.controller;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import com.qienProgramma.model.Employee;

@Component
public interface EmployeeRepository extends CrudRepository<Employee, Long>{

}

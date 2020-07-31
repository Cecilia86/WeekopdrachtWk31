package com.qienProgramma.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.qienProgramma.controller.EmployeeService;
import com.qienProgramma.model.Employee;

@RestController
@RequestMapping("/api/Employee")
public class EmployeeEndpoint {
	 @Autowired
	    EmployeeService es;

	    @PostMapping("/new")
	    public Employee addEmployee(@RequestBody Employee employee) {
	        return es.addEmployee(employee);
	    }

	    @GetMapping("/all")
	    public Iterable<Employee> getEmployees(){
	        return es.getAllEmployees();
	    }

	    @GetMapping("/id/{id}")
	    public Employee getEmployeeByID(@PathVariable(value = "id") long id){
	        return es.getById(id);
	    }

	    @DeleteMapping("/delete/{id}")
	    public void deleteEmployeeById(@PathVariable(value = "id") long id) {
	        es.deleteEmployeeById(id);
	    }
}

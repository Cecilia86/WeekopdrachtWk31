package com.qienProgramma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import com.qienProgramma.model.Employee;

public class EmployeeService {
	
	 @Autowired
	    EmployeeRepository er;

	    public Employee getById(long id) {
	        return er.findById(id).get();
	    }
	    public void inDeService() {
	        er.save(new Employee());
	        System.out.println("We zijn in de service ");
	    }

	    public Employee addEmployee(Employee employee){
	        System.out.println("In employee Service");
	        return er.save(employee);
	    }

	    public Iterable<Employee> getAllEmployees(){
	        System.out.println("getAllDepartments aangeroepen");
	        return er.findAll();
	    }

	    public void deleteEmployeeById(long id) {
	        System.out.println("DELETE IN SERVICE");
	        er.deleteById(id);
	    }

}

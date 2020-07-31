package com.qienProgramma.rest;

import com.qienProgramma.controller.DepartmentRepository;
import com.qienProgramma.controller.DepartmentService;
import com.qienProgramma.controller.EmployeeRepository;
import com.qienProgramma.model.Department;
import com.qienProgramma.model.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Department")
public class DepartmentEndpoint {

    @Autowired
    DepartmentService ds;
    
    @Autowired
    DepartmentRepository dr;
    
    @Autowired
    EmployeeRepository er;

    @PostMapping("/new")
    public Department addDepartment(@RequestBody Department department) {
        return ds.addDepartment(department);
    }

    @GetMapping("/all")
    public Iterable<Department> getDepartments(){
        return ds.getAllDepartments();
    }

    @GetMapping("/id/{id}")
    public Department getDepartmentByID(@PathVariable(value = "id") long id){
        return ds.getById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteDepartmentById(@PathVariable(value = "id") long id) {
        ds.deleteDepartmentById(id);
    }

    @PutMapping("/update/{id}")
    public  Department updateDepartment(@PathVariable(value = "id") long id, @RequestBody Department department) {
        return ds.updateDepartment(id, department);
    }

    @PostMapping("/dopost")
    public String doPost(@RequestBody Department dp) {
        System.out.println(dp.getName() + dp.getEmployees());
        return "Post is gelukt";
    }

    @GetMapping("/checkdeservice")
    public String checkDeService() {
        System.out.println("Het werkt");
        ds.inDeService();
        return "Reply: Check de Service";
    }
    
	public Department addEmployee(long departmentid, long employeeid) {
		Department department  = dr.findById(departmentid).get();
		Employee employee = er.findById(employeeid).get();
		department.addEmployees(employee);
		System.out.println("employee added to department in database");
		return dr.save(department);
	}
}

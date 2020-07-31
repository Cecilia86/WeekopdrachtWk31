package com.qienProgramma.controller;

import com.qienProgramma.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DepartmentService {

    @Autowired
    DepartmentRepository dr;

    public Department getById(long id) {
        return dr.findById(id).get();
    }
    public void inDeService() {
        dr.save(new Department());
        System.out.println("We zijn in de service ");
    }

    public Department addDepartment(Department department){
        System.out.println("In department Service");
        return dr.save(department);
    }

    public Iterable<Department> getAllDepartments(){
        System.out.println("getAllDepartments aangeroepen");
        return dr.findAll();
    }

    public void deleteDepartmentById(long id) {
        System.out.println("DELETE IN SERVICE");
        dr.deleteById(id);
    }

    public Department updateDepartment(long id, Department department) {
        System.out.println("UPDATE DEPARTMENT BY ID");
        Department dp = dr.findById(id).get();
        if(department.getName() != null && dp.getName() != "") {
            dp.setName(department.getName());
        }
        dp.setEmployees((department.getEmployees()));
        return dr.save(dp);
    }
}

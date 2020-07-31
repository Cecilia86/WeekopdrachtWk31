package com.qienProgramma.rest;

import com.qienProgramma.controller.*;
import com.qienProgramma.model.DepManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/DepManager")
public class DepManagerEndpoint {

    @Autowired
    DepManagerService ms;

    @PostMapping("/new")
    public DepManager addDepartment(@RequestBody DepManager department) {
        return ms.addDepManager(department);
    }

    @GetMapping("/all")
    public Iterable<DepManager> getDepartments(){
        return ms.getAllDepManagers();
    }

    @GetMapping("/id/{id}")
    public DepManager getDepartmentByID(@PathVariable(value = "id") long id){
        return ms.getById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteDepartmentById(@PathVariable(value = "id") long id) {
        ms.deleteDepManagerById(id);
    }

    @PostMapping("/dopost")
    public String doPost(@RequestBody DepManager dp) {
        System.out.println(dp.getName() + dp.getSalary());
        return "Post is gelukt";
    }

    @GetMapping("/abc")
    public DepManager jojojo(){
        return new DepManager();
    }
}

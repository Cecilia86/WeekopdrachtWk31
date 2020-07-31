package com.qienProgramma.controller;

import com.qienProgramma.model.DepManager;
import com.qienProgramma.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DepManagerService {

    @Autowired
    DepManagerRepository dm;

    public DepManager getById(long id) {
        return dm.findById(id).get();
    }

    public DepManager addDepManager(DepManager depman){
        System.out.println("In departmentManager Service");
        return dm.save(depman);
    }

    public Iterable<DepManager> getAllDepManagers(){
        System.out.println("getAllDepartments aangeroepen");
        return dm.findAll();
    }

    public void deleteDepManagerById(long id) {
        System.out.println("DELETE IN SERVICE");
        dm.deleteById(id);
    }
}

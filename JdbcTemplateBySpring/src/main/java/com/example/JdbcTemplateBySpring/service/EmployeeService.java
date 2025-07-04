package com.example.JdbcTemplateBySpring.service;


import com.example.JdbcTemplateBySpring.repo.EmployeeRepo;
import com.example.JdbcTemplateBySpring.model.EmployeeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {


    private EmployeeRepo employeeRepo;

    public EmployeeRepo getEmployeeRepo() {
        return employeeRepo;
    }


    @Autowired
    public void setEmployeeRepo(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public  void addEmployee(EmployeeInfo employeeInfo){
         employeeRepo.save(employeeInfo);
    }

    public List<EmployeeInfo> getAll(){
        return  employeeRepo.employeeInfoList();
    }
}

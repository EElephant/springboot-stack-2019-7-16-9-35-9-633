package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.Employee;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private List<Employee> employees = new ArrayList<>();
    public void initEmployees(){
        employees.add(new Employee(0,"Mike",18,"Male",5000));
        employees.add(new Employee(0,"Tom",20,"Male",7000));
    }

}

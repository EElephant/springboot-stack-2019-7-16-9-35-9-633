package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.Company;
import com.tw.apistackbase.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    List<Company> companys= new ArrayList<>();
    private List<Employee> employees = new ArrayList<>();
    public void initCompanys(){
        employees.add(new Employee(0,"Mike",18,"Male",5000));
        employees.add(new Employee(1,"Tom",20,"Male",7000));
        companys.add(new Company(0,"alibaba",2,employees));
        companys.add(new Company(1,"huawei",2,employees));
    }

    @GetMapping
    public List<Company> getAllCompanies(){
        initCompanys();
        return companys;
    }

    @GetMapping("/{id}")
    public Company getSpecificCompany(@PathVariable int id){
        initCompanys();
        return companys.get(id);
    }

    @GetMapping("/{id}/employees")
    public List<Employee> getEmployeeByCompany(@PathVariable int id){
        initCompanys();
        return companys.get(id).getEmployees();
    }
}

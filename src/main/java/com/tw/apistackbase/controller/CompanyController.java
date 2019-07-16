package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.Company;
import com.tw.apistackbase.model.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    List<Company> companys= new ArrayList<>();
    private List<Employee> employees = new ArrayList<>();
    public void initCompanys(){
        employees.add(new Employee(0,"Mike",18,"Male",6000));
        employees.add(new Employee(1,"Tom",20,"Male",7000));
        employees.add(new Employee(2,"Jucy",19,"Female",8000));
        employees.add(new Employee(3,"John",22,"Male",9000));
        companys.add(new Company(0,"alibaba",4,employees));
        companys.add(new Company(1,"huawei",4,employees));
        companys.add(new Company(2,"tenxun",4,employees));
        companys.add(new Company(3,"baidu",4,employees));
        companys.add(new Company(4,"360",4,employees));
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

//    @GetMapping
//    public List<Company>

    @PostMapping
    public void addCompany(@RequestBody Company company){
        initCompanys();
        companys.add(company);
    }

    @PutMapping("/{id}")
    public void updateCompany(@RequestBody Company company){
        initCompanys();
        companys.get(company.getId()).setCompanyName(company.getCompanyName());
        companys.get(company.getId()).setEmployeesNumber(company.getEmployeesNumber());
        companys.get(company.getId()).setEmployees(company.getEmployees());
    }

    @DeleteMapping("/{id}")
    public void deleteCompany(@PathVariable int id){
        initCompanys();
        companys.remove(id);
    }
}

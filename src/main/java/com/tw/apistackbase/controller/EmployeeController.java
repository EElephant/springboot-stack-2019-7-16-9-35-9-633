package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.Employee;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private List<Employee> employees = new ArrayList<>();
    public void initEmployees(){
        employees.add(new Employee(0,"Mike",18,"Male",6000));
        employees.add(new Employee(1,"Tom",20,"Male",7000));
        employees.add(new Employee(2,"Jucy",19,"Female",8000));
        employees.add(new Employee(3,"John",22,"Male",9000));
    }

    @GetMapping("/{id}")
    public Employee getSpecificEmployee(@PathVariable int id){
        initEmployees();
        return employees.stream().filter(item -> item.getId() == id).collect(Collectors.toList()).get(0);
    }

    @GetMapping
    public List<Employee> getEmployeeByGender(@RequestParam(value = "gender",defaultValue = "all") String gender,
                                              @RequestParam(value = "page",defaultValue = "0") int page,
                                              @RequestParam(value = "pageSize",defaultValue = "0") int pageSize){
        initEmployees();
        if(gender.equals("all")&&page==0&&pageSize==0){
            return employees;
        }else if(!gender.equals("all")){
            return employees.stream().filter(item -> item.getGender().equals(gender)).collect(Collectors.toList());
        }else{
            return employees.subList(page-1,pageSize);
        }
    }

    @PostMapping
    public void addEmployee(@RequestBody Employee employee){
        initEmployees();
        employees.add(employee);
    }

    @PutMapping("/{id}")
    public void updateEmployee(@RequestBody Employee employee){
        initEmployees();
        employees.get(employee.getId()).setName(employee.getName());
        employees.get(employee.getId()).setAge(employee.getAge());
        employees.get(employee.getId()).setGender(employee.getGender());
        employees.get(employee.getId()).setSalary(employee.getSalary());
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable int id){
        initEmployees();
        employees.remove(id);
    }
}

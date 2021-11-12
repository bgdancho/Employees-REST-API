package com.karabelyov.yordan.Employees.controller;

import com.karabelyov.yordan.Employees.model.Employee;
import com.karabelyov.yordan.Employees.results.ResultObject;
import com.karabelyov.yordan.Employees.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/employees")
public class Controller {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/all")
    public List<Employee> allEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("getById/{id}")
    public Employee getEmployeeById(@PathVariable("id") int id) {
        return employeeService.findById(id);
    }

    @PostMapping(value = "/save")
    public void saveEmployee(@RequestBody Employee employee) {

        if (employee.getId() != null) {
            Employee employeeResult = employeeService.findById(employee.getId());
            employeeResult.setName(employee.getName());
            employeeResult.setAddress(employee.getAddress());
            employeeResult.setTechnology(employee.getTechnology());
            employeeResult.setAge(employee.getAge());
            employeeService.save(employeeResult);
            return;
        }
        employeeService.save(employee);
    }

    @GetMapping("/{word}")
    public List<Employee> employeesByName(@PathVariable("word") String word) {
        return employeeService.findAllByString(word);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable("id") int id) {
        employeeService.deleteById(id);
    }

    @GetMapping("/employee")
    public ResultObject employeesByNamePaginated(@RequestParam String value, @RequestParam int page, @RequestParam int pageSize) {

        ResultObject employees = employeeService.findPagination(value, page, pageSize);
        if (employees == null) {
            return new ResultObject(0,new ArrayList<>());
        }
        return employees;
    }
}

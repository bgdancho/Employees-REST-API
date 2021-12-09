package com.karabelyov.yordan.Employees.controller;

import com.karabelyov.yordan.Employees.model.Employee;
import com.karabelyov.yordan.Employees.results.ResultObject;
import com.karabelyov.yordan.Employees.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/")
    public ResultObject get(@RequestParam String filter, @RequestParam int page, @RequestParam int pageSize, @RequestParam(defaultValue = "id") String orderBy) {
        ResultObject employees = employeeService.findPagination(filter, page, pageSize, orderBy);
        return employees;
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable("id") int id) {
        return employeeService.findById(id);
    }

    @PostMapping(value = "/")
    public void post(@RequestBody Employee employee) {
        employeeService.save(employee);
    }

    @PutMapping(value = "/")
    public Employee put(@RequestBody Employee employee) {
        if (employee.getId() != null) {
            Employee employeeResult = employeeService.findById(employee.getId());
            employeeResult.setName(employee.getName());
            employeeResult.setAddress(employee.getAddress());
            employeeResult.setTechnology(employee.getTechnology());
            employeeResult.setAge(employee.getAge());
            employeeService.save(employeeResult);
            return employee;
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable("id") int id) {
        employeeService.deleteById(id);
    }
}

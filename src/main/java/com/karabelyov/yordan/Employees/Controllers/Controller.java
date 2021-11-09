package com.karabelyov.yordan.Employees.Controllers;

import com.karabelyov.yordan.Employees.exceptions.EmployeeNotFound;
import com.karabelyov.yordan.Employees.model.Employee;
import com.karabelyov.yordan.Employees.results.ResultObject;
import com.karabelyov.yordan.Employees.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @GetMapping("/save")
    public void saveEmployeeById(@RequestParam  int id , @RequestParam String name, @RequestParam String tech, @RequestParam String address, @RequestParam int age) {
        employeeService.save(id, name, tech, address, age);
    }
    @GetMapping("/saveNew")
    public void saveNewEmployee(@RequestParam String name, @RequestParam String tech, @RequestParam String address, @RequestParam int age) {
        employeeService.save(name, tech, address, age);
    }

    @GetMapping("/{word}")
    public List<Employee> employeesByName(@PathVariable("word") String word) {
        return employeeService.findAllByString(word);
    }

    @GetMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable("id") int id) {
        employeeService.deleteById(id);
    }


    @GetMapping("/page")
    public ResultObject employeesByNamePaginated(@RequestParam String value, @RequestParam int page, @RequestParam int pageSize) throws EmployeeNotFound {

        ResultObject employees = employeeService.findPagination(value, page, pageSize);

        if (employees == null) {
            throw new EmployeeNotFound();
        }
        return employees;
    }
}

package com.karabelyov.yordan.Employees.service;

import com.karabelyov.yordan.Employees.model.Employee;
import com.karabelyov.yordan.Employees.results.ResultObject;


import java.util.List;


public interface EmployeeService {


    Employee save(Employee employee);

    Employee findById(int id);
    Employee findById(Long id);

    List<Employee> findAll();

    List<Employee> findAllByString(String word);


    void deleteById(int id);

    ResultObject findPagination(String word, int page, int pageSize);

}

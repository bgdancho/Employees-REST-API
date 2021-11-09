package com.karabelyov.yordan.Employees.service;

import com.karabelyov.yordan.Employees.model.Employee;
import com.karabelyov.yordan.Employees.results.ResultObject;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EmployeeService {

    Employee save(int id,String name, String tech, String address, int age );
    Employee save(String name, String tech, String address, int age );

    Employee save(Employee employee);

    Employee findById(int id);

    List<Employee> findAll();

    List<Employee> findAllByString(String word);

    List<Employee> findAllByInt(int digit);

    void deleteById(int id);

    ResultObject findPagination(String word, int page, int pageSize);

}

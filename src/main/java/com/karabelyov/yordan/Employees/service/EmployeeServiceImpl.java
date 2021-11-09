package com.karabelyov.yordan.Employees.service;

import com.karabelyov.yordan.Employees.model.Employee;
import com.karabelyov.yordan.Employees.repository.EmployeeRepository;
import com.karabelyov.yordan.Employees.results.ResultObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService {


    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employee save(Employee employee) {

        return employeeRepository.save(employee);
    }

    @Override
    public Employee save(int id, String name, String tech, String address, int age) {

        Long idToFind = Long.valueOf(id);
        Employee employee = employeeRepository.findById(idToFind).get();
        employee.setAddress(address);
        employee.setTechnology(tech);
        employee.setName(name);
        employee.setAge(age);
        return employeeRepository.save(employee);
    }

    @Override
    public Employee save(String name, String tech, String address, int age) {


        Employee employee = new Employee();
        employee.setAddress(address);
        employee.setTechnology(tech);
        employee.setName(name);
        employee.setAge(age);
        System.out.println(employee);
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> findAllByString(String word) {
        try {
            int number = Integer.parseInt(word);
            List employeeList = new ArrayList(employeeRepository.find(word, number));
            return employeeList;
        } catch (NumberFormatException e) {
            List employeeList = new ArrayList(employeeRepository.findByName(word));
            return employeeList;
        }

    }

    @Override
    public Employee findById(int id) {
        Long idToFind = Long.valueOf(id);
        if (idToFind > 0) {
            return employeeRepository.findById(idToFind).get();
        }
        return null;
    }

    @Override
    public List<Employee> findAllByInt(int digit) {
        return employeeRepository.findByInt(digit);
    }

    @Override
    public void deleteById(int id) {
        Long idToDelete = Long.valueOf(id);
        if (id > 0 && employeeRepository.existsById(idToDelete)) {
            employeeRepository.deleteById(idToDelete);
        }
    }

    @Override
    public ResultObject findPagination(String word, int page, int pageSize) {

        List<Employee> employees = findAllByString(word);
        if (employees.isEmpty()) {
            return null;
        }

        if (employees.size() <= pageSize) {
            pageSize = employees.size();
        }

        int totalPages = getPages(pageSize, employees);


        if (page >= totalPages) {
            return null;
        }

        if (page == 0) {
            return
                    new ResultObject(totalPages, employees.subList(0, pageSize));
        }

        if (page != totalPages - 1) {
            return
                    new ResultObject(totalPages, employees.subList(page * pageSize, (page + 1) * pageSize));
        }
        return
                new ResultObject(totalPages, employees.subList(page * pageSize, employees.size()));


    }

    private int getPages(int pageSize, List<Employee> employees) {
        int employeesCount = employees.size();

        int pages = employeesCount / pageSize;


        if (employeesCount % pageSize != 0) {
            pages++;
        }
        return pages;
    }
}

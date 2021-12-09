package com.karabelyov.yordan.Employees.service;

import com.karabelyov.yordan.Employees.model.Employee;
import com.karabelyov.yordan.Employees.repository.EmployeeRepository;
import com.karabelyov.yordan.Employees.results.ResultObject;
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
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> findAllByString(String filter, String orderBy) {

        switch (orderBy) {
            case "address": {
                List<Employee> employeeList = new ArrayList(employeeRepository.findAllByNameOrderByAddress(filter));
                return employeeList;
            }
            case "technology": {
                List<Employee> employeeList = new ArrayList(employeeRepository.findAllByNameOrderByTechnology(filter));
                return employeeList;
            }
            case "name": {
                List<Employee> employeeList = new ArrayList(employeeRepository.findAllByNameOrderByName(filter));
                return employeeList;
            }
            default: {
                List<Employee> employeeList = new ArrayList(employeeRepository.findAllByNameOrderById(filter));
                return employeeList;
            }
        }
    }

    @Override
    public Employee findById(int id) {
        Long idToFind = Long.valueOf(id);
        if (idToFind > 0) {
            return employeeRepository.findById(idToFind).get();
        }
        return new Employee();
    }

    @Override
    public Employee findById(Long id) {
        if (id > 0) {
            return employeeRepository.findById(id).get();
        }
        return new Employee();
    }

    @Override
    public void deleteById(int id) {
        Long idToDelete = Long.valueOf(id);
        if (id > 0 && employeeRepository.existsById(idToDelete)) {
            employeeRepository.deleteById(idToDelete);
        }
    }

    @Override
    public ResultObject findPagination(String filter, int page, int pageSize, String orderBy) {

        List<Employee> employees = findAllByString(filter, orderBy);
        if (employees.isEmpty()) {
            return new ResultObject(0, employees);
        }

        if (employees.size() <= pageSize) {
            pageSize = employees.size();
        }

        int totalPages = getPages(pageSize, employees);


        if (page >= totalPages) {
            return new ResultObject(0, employees);
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

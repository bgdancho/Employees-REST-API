package com.karabelyov.yordan.Employees.results;

import com.karabelyov.yordan.Employees.model.Employee;

import java.util.List;

public class ResultObject {
    private int totalPages;
    private List<Employee> employeeList;

    public ResultObject(int totalPages, List<Employee> employeeList) {
        this.totalPages = totalPages;
        this.employeeList = employeeList;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    public String toString() {
        return "ResultObject{" +
                "totalPages=" + totalPages +
                ", employeeList=" + employeeList +
                '}';
    }
}

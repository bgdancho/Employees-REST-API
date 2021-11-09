package com.karabelyov.yordan.Employees;

import com.karabelyov.yordan.Employees.model.Employee;
import com.karabelyov.yordan.Employees.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class EmployeesApplication implements CommandLineRunner {

    @Autowired
    EmployeeService employeeService;

    public static void main(String[] args) {
        SpringApplication.run(EmployeesApplication.class, args);
    }


    @Override
    @Transactional
    public void run(String... args) {


        Employee employee = new Employee("Yordan", "Java", "Sofia", 18);
        Employee employee1 = new Employee("Ivan", "JavaScript", "Sofia", 2);
        Employee employee2 = new Employee("Minka", "PHP", "Sofia", 23);
        Employee employee3 = new Employee("Oleg", "React", "Sofia", 50);
        Employee employee4 = new Employee("Petur", "Angular", "Sofia", 19);
        Employee employee5 = new Employee("Toni", "C#", "Sofia", 22);
        Employee employee6 = new Employee("Tanq", "PHP", "Sofia", 48);
        Employee employee7 = new Employee("Tinka", "GO", "Sofia", 54);
        Employee employee8 = new Employee("Tenio", "Ruby On Rails", "Sofia", 35);
        Employee employee9 = new Employee("Ahmed", "Phyton", "Sofia", 38);
        Employee employee10 = new Employee("Muhamed", "Phyton", "Sofia", 34);
        Employee employee11 = new Employee("Ali", "Node.js", "Sofia", 18);
        Employee employee12 = new Employee("Hasan", "jQuery", "Plovdiv", 24);
        Employee employee13 = new Employee("Dimitar", "Node.js", "Simitli", 43);
        Employee employee14 = new Employee("Dragan", "jQuery", "Nesebur", 39);

        employeeService.save(employee);
        employeeService.save(employee1);
        employeeService.save(employee2);
        employeeService.save(employee3);
        employeeService.save(employee4);
        employeeService.save(employee5);
        employeeService.save(employee6);
        employeeService.save(employee7);
        employeeService.save(employee8);
        employeeService.save(employee9);
        employeeService.save(employee10);
        employeeService.save(employee11);
        employeeService.save(employee12);
        employeeService.save(employee13);
        employeeService.save(employee14);

    }

}

package com.karabelyov.yordan.Employees.repository;

import com.karabelyov.yordan.Employees.model.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee save(Employee employee);

    List<Employee> findAll();

    Employee findById(int id);

    @Query(value ="SELECT * FROM EMPLOYEE WHERE NAME like %:string% OR ADDRESS like %:string% OR TECHNOLOGY like %:string% OR ID like %:string% OR AGE like %:string%", nativeQuery = true)
    List<Employee> findByName(@Param("string") String string);

    void deleteById(Long id);

}

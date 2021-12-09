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

    @Query(value = "SELECT * FROM EMPLOYEE WHERE NAME like %:string% OR ADDRESS like %:string% OR TECHNOLOGY like %:string% OR ID like %:string% OR AGE like %:string% ORDER BY ID", nativeQuery = true)
    List<Employee> findAllByNameOrderById(@Param("string") String string);

    @Query(value = "SELECT * FROM EMPLOYEE WHERE NAME like %:string% OR ADDRESS like %:string% OR TECHNOLOGY like %:string% OR ID like %:string% OR AGE like %:string% ORDER BY ADDRESS", nativeQuery = true)
    List<Employee> findAllByNameOrderByAddress(@Param("string") String string);

    @Query(value = "SELECT * FROM EMPLOYEE WHERE NAME like %:string% OR ADDRESS like %:string% OR TECHNOLOGY like %:string% OR ID like %:string% OR AGE like %:string% ORDER BY TECHNOLOGY", nativeQuery = true)
    List<Employee> findAllByNameOrderByTechnology(@Param("string") String string);

    @Query(value = "SELECT * FROM EMPLOYEE WHERE NAME like %:string% OR ADDRESS like %:string% OR TECHNOLOGY like %:string% OR ID like %:string% OR AGE like %:string% ORDER BY NAME", nativeQuery = true)
    List<Employee> findAllByNameOrderByName(@Param("string") String string);

    void deleteById(Long id);
}

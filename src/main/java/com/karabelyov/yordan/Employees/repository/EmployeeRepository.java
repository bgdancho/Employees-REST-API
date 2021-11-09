package com.karabelyov.yordan.Employees.repository;

import com.karabelyov.yordan.Employees.model.Employee;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {

    Employee save(Employee employee);

    List<Employee> findAll();

    Employee findById(int id);

    @Query(value ="SELECT * FROM EMPLOYEE WHERE NAME= :string OR ADDRESS= :string OR TECHNOLOGY=:string", nativeQuery = true)
    List<Employee> findByName(@Param("string") String string);

    @Query(value ="SELECT * FROM EMPLOYEE WHERE ID= :integer OR AGE= :integer", nativeQuery = true)
    List<Employee> findByInt(@Param("integer") int integer);

    default Set<Employee> find(@Param("string") String string, @Param("integer") int integer) {
        Set<Employee> list = new HashSet<>(findByName(string));
        list.addAll(findByInt(integer));
        return list;
    };

    void deleteById(Long id);

}

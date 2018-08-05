package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeDao extends CrudRepository<Employee, Integer> {

    @Query
    List<Employee> getEmployeesWithLastName(@Param("LASTNAME") String lastname);

//    @Query
//    List<Employee> getEmployeesWithNameLike(@Param("EMPLOYEE_LASTNAME") String lastname);

    List<Employee> findByLastnameContainingIgnoreCaseOrFirstnameContainingIgnoreCase(String firstname, String lastname);
}

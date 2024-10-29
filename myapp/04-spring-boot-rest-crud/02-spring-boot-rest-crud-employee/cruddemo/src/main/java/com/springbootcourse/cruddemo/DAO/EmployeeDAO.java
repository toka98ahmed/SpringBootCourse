package com.springbootcourse.cruddemo.DAO;

import com.springbootcourse.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    // retrieve all employees

    List<Employee> findAll();

    // retrieve an employee by id

    Employee findById(int id);

    // save a new employee

    Employee save(Employee employee);

    // delete employee by id

    void delete(int theId);
}

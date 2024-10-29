package com.springbootcourse.cruddemo.service;

import com.springbootcourse.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int id);

    // save a new employee

    Employee save(Employee employee);

    // delete employee by id

    void delete(int theId);
}

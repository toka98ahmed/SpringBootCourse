package com.springbootcourse.cruddemo.service;


import com.springbootcourse.cruddemo.dao.EmployeeRepository;
import com.springbootcourse.cruddemo.entity.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> result = employeeRepository.findById(id);

        Employee theEmployee = null;
        if(result.isPresent())
        {
            theEmployee = (Employee)result.get();
        }
        else
        {
            throw new RuntimeException("Employee not found - "+id);
        }
        return theEmployee;
    }

    @Override

    public Employee save(Employee employee) {
        return (Employee) employeeRepository.save(employee);
    }

    @Override
    public void delete(int theId) {
        employeeRepository.deleteById(theId);
    }
}

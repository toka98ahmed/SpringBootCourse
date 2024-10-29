package com.springbootcourse.cruddemo.rest;

import com.springbootcourse.cruddemo.DAO.EmployeeDAO;
import com.springbootcourse.cruddemo.entity.Employee;
import com.springbootcourse.cruddemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/employees")
    public List<Employee> findall(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable int employeeId){
        return employeeService.findById(employeeId);
    }

    // so because this method uses a merge. If the id already exists it updates the object
    // if not, it creates a new one
    // so to force it to create a new one. If an id is passed in JSON we set it to 0
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        employee.setId(0);

       return employeeService.save(employee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Employee temp = employeeService.findById(employeeId);

        if (temp == null){
            throw new RuntimeException("Employee not found - "+employeeId);
        }
        employeeService.delete(employeeId);
        return "Employee deleted - "+employeeId;
    }


}

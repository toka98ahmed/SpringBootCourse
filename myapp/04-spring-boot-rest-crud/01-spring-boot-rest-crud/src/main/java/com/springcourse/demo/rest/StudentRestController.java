package com.springcourse.demo.rest;


import com.springcourse.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    List<Student> students;

    // define @PostConstruct to load the student data..only once!
    @PostConstruct
     public void loadData()
    {
        students = new ArrayList<>();

        students.add(new Student("John", "Doe"));
        students.add(new Student("Mary", "Smith"));
        students.add(new Student("Matt", "Jackson"));
    }



    // define endpoint for

    @GetMapping("/students")
    public List<Student> getStudents(){

        return students;
    }

    // define endpoint for a specific student

    @GetMapping("/students/{studentid}")
    public Student getStudent(@PathVariable int studentid){
        return students.get(studentid);
    }

}

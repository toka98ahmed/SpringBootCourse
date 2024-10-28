package com.springcourse.demo.rest;


import com.springcourse.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){

        // check student id
        if (studentId < 0 || studentId >= students.size())
        {
            throw new StudentNotFoundException("Student id not found - "+studentId);
        }
        else {
            return students.get(studentId);
        }
    }

    // add an exception handler

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleStudentNotFoundException(StudentNotFoundException ex)
    {
        // create a student error response

        StudentErrorResponse errorResponse = new StudentErrorResponse();
        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setTimestamp(System.currentTimeMillis());

        // return response entity
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

}

package com.springbootcourse.cruddemo.dao;

import com.springbootcourse.cruddemo.entity.Student;

import java.util.List;


public interface StudentDAO {

    void save(Student theStudent);

    Student findById(Integer theId);

    List<Student> findAll();

    List<Student> findByLastName(String theLastName);

    void update(Student theStudent);

    void delete(Integer theId);

    int deleteAll();
}

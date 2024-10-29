package com.springbootcourse.cruddemo.DAO;

import com.springbootcourse.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImp implements EmployeeDAO {


    // define entity manager
    private EntityManager entityManager;

    // set up constructor injection
    @Autowired
    public EmployeeDAOImp(EntityManager em) {
        this.entityManager = em;
    }


    @Override
    public List<Employee> findAll() {

        // create a query

        TypedQuery<Employee> query = entityManager.createQuery("from employee", Employee.class);

        // execute query


        return query.getResultList();
    }

    @Override
    public Employee findById(int id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public Employee save(Employee employee) {
        return entityManager.merge(employee);
    }

    @Override
    public void delete(int theId) {
        Employee employee = entityManager.find(Employee.class, theId);
        entityManager.remove(employee);

    }
}

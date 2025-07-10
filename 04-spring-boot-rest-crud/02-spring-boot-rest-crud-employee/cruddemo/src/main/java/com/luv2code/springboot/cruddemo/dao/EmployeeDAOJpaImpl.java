package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    // defie field for entitymanager
    private EntityManager em;

    // set up constuctor injection
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager theEntityMenager){
        em=theEntityMenager;
    }

    @Override
    public List<Employee> findAll() {

        // create a query
        TypedQuery<Employee> theQuery=em.createQuery("from Employee", Employee.class);

        // execute query and get result list
        List<Employee> employees=theQuery.getResultList();

        // return the results
        return employees;
    }
}

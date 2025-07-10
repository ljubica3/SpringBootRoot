package com.luv2code.demo.rest;

import com.luv2code.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.View;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private final View error;
    private List<Student> theStudents;

    public StudentRestController(View error) {
        this.error = error;
    }

    // define @PostConstructor to load the student data... only once!

    @PostConstruct
    public void loadData(){     //much better...only load student data once

        theStudents=new ArrayList<>();

        theStudents.add(new Student("Ivana","Stefanov"));
        theStudents.add(new Student("Anja","Stevic"));
        theStudents.add(new Student("Lana","Zivkov"));
    }

    // define endpoint for "/students" - return a list of students

    @GetMapping("/students")
    public List<Student> getStudents(){

        return theStudents;
    }

    // define endpoint or "/students/{studentId}" - return student at index

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){

        // just index into list ... keep it simple for now

        // check the studentId again list size

        if((studentId>=theStudents.size()) || (studentId<0)){
            throw new StudentNotFoundException("Student id not found - "+studentId);
        }

        return theStudents.get(studentId);
    }

    // add an exception handler using @ExceptionHandler


}








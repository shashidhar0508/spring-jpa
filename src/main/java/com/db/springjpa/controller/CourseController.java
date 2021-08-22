package com.db.springjpa.controller;

import com.db.springjpa.entity.Course;
import com.db.springjpa.repository.CourseJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseJpaRepository courseJpaRepository;

    @GetMapping("/getById/{id}")
    public Course getCourseById(@PathVariable("id") Long id){
        return courseJpaRepository.getById(id);
    }
}

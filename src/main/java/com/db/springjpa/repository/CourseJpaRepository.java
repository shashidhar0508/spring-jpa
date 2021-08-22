package com.db.springjpa.repository;

import com.db.springjpa.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseJpaRepository extends JpaRepository<Course, Long> {

    public Course getById(Long id);
}

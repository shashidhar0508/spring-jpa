package com.db.springjpa.repository;

import com.db.springjpa.entity.Instructor;
import com.db.springjpa.entity.TableHistory;
import com.db.springjpa.entity.Technology;
import com.db.springjpa.entity.TechnologyMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
class TechnologyRepositoryTest {

    @Autowired
    private TechnologyRepository  technologyRepository;

    @Autowired
    private TechMaterialRepository techMaterialRepository;

    @Test
    public void showTechnologies(){
        List<Technology> all = technologyRepository.findAll();
        System.out.println("all = " + all);
    }

    @Test
    public void saveTechnologyWithInstructor() {
        TableHistory tableHistory = new TableHistory(
                "shashidhar",
                new Date(),
                "shashidhar",
                new Date()
        );

//        final TechnologyMaterial save1 = techMaterialRepository.save(new TechnologyMaterial("www.python.com", tableHistory));
//
        TechnologyMaterial technologyMaterial = new TechnologyMaterial("www.python.com", tableHistory);

//        In this method if I give "technologyMaterial" and save it, I'm getting below error(so I commented technologyMaterial below)("need to check")
        /*org.hibernate.TransientPropertyValueException: object references an unsaved transient instance -
                save the transient instance before flushing : com.db.springjpa.entity.Technology.technologyMaterial -> com.db.springjpa.entity.TechnologyMaterial;
                nested exception is java.lang.IllegalStateException: org.hibernate.TransientPropertyValueException: object references an unsaved transient instance - save the transient instance before flushing : com.db.springjpa.entity.Technology.technologyMaterial -> com.db.springjpa.entity.TechnologyMaterial
        org.springframework.dao.InvalidDataAccessApiUsageException: org.hibernate.TransientPropertyValueException: object references an unsaved transient instance -
                save the transient instance before flushing : com.db.springjpa.entity.Technology.technologyMaterial -> com.db.springjpa.entity.TechnologyMaterial;
                nested exception is java.lang.IllegalStateException: org.hibernate.TransientPropertyValueException: object references an unsaved transient instance - save the transient instance before flushing : com.db.springjpa.entity.Technology.technologyMaterial -> com.db.springjpa.entity.TechnologyMaterial*/

        Instructor instructor = new Instructor("Monty1", "Python1");

//        Technology python = new Technology("PythonTech", 81, instructor, technologyMaterial, tableHistory);
        Technology python = new Technology("PythonTech", 81, instructor, tableHistory);

        final Technology save = technologyRepository.save(python);

        System.out.println("save = " + save);

    }

}
package com.db.springjpa.repository;

import com.db.springjpa.entity.TableHistory;
import com.db.springjpa.entity.Technology;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootTest
class InstructorRepositoryTest {

    @Autowired
    private InstructorRepository instructorRepository;

    @Test
    public void saveInstructor(){

        TableHistory tableHistory = new TableHistory(
                "shashidhar",
                new Date(),
                "shashidhar",
                new Date()
        );

        List<Technology> dsa = Arrays.asList(new Technology("DSA",6,tableHistory),
                                            new Technology("Core Java",4,tableHistory),
                                            new Technology("Advanced Java",3,tableHistory));

//        Instructor instructor = new Instructor(
//                "srinivas",
//                "nit",
//                dsa
////                List.of(core_java)
//        );
//
//        Instructor saveInstructorRepository = instructorRepository.save(instructor);
//        System.out.println("saveInstructorRepository = " + saveInstructorRepository);
    }

}
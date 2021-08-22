package com.db.springjpa.repository;

import com.db.springjpa.entity.Student;
import com.db.springjpa.entity.TableHistory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
//@DataJpaTest  //It will help you to test repository layer and once the operation is completed it will flush the data, by which database won't be impacted
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
//        Student student = new Student(
//                "Shashidhar",
//                "shashidhar@gamil.com",
//                "Ammerpet",
//                "NIT");
//        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithTableHistory(){
        TableHistory tableHistory = new TableHistory(
                "shashidhar",
                new Date(),
                "shashidhar",
                new Date()
        );
        
        Student student = new Student(
                "Shashidhar",
                "shashidhar@gamil.com",
                tableHistory
        );

        final Student saveStudent = studentRepository.save(student);
    }

    @Test
    public void showAllStudents(){
        List<Student> studentList = studentRepository.findAll();
        System.out.println("studentList: "+studentList);
    }

}
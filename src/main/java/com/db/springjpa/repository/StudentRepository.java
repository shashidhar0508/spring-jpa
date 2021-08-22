package com.db.springjpa.repository;

import com.db.springjpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    public List<Student> findByEmailId(String emailId);

    // caseSensitive to overcome we need to use IgnoreCase
    public List<Student> findByNameContaining(String name);

    public List<Student> findByNameNotNull();

    // Embedded table data retrieval
    public List<Student> findByTableHistoryCreatedByIgnoreCase(String name);

    // JPQL  ===> Here we need to give class name and property names of Class not table names and properties from db
    @Query("Select s from Student s where s.emailId = ?1")
    Student findByEmailAddress(String email);

    // JPQL
    @Query("Select s.name from Student s where s.emailId = ?1")
    String findNameByEmailAddress(String email);

    // Native Query  ===> Here we need to give table names and properties from db not class name and property names of Class
    // In below query we can't give "s" in place of "*"
    @Query(
            value = "Select * from tbl_student s where s.email_address = ?1",
            nativeQuery = true
    )
    Student findByEmailAddressNative(String email);

    // Native Named Param
    // In below query we can't give "s" in place of "*"
    @Query(
            value = "Select * from tbl_student s where s.email_address = :emailID",
            nativeQuery = true
    )
    Student findByEmailAddressNativeNamedParam(
            @Param("emailID") String email);

    @Transactional  // If anything fails in middle it rolls back everything
    @Modifying
    @Query(
            value = "update tbl_student set name=:student_name where email_address=:emailId",
            nativeQuery = true
    )
    int updateStudentNameByEmailAddress(
            @Param("student_name") String name,
            @Param("emailId") String emailId);
}

package com.db.springjpa.entity;

import javax.persistence.*;

@Entity
@Table(
        name = "tbl_student",
        uniqueConstraints = @UniqueConstraint(
                name = "emailid_unique",
                columnNames = "email_address"
        ),
        schema = "spring_jpa"
)
public class Student {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long studentId;

    private String name;

    @Column(
            name = "email_address",
            nullable = false
    )
    private String emailId;

    @Embedded   //Using TableHistory properties here
    private TableHistory tableHistory;

    public Student() {
    }

    public Student(String name, String emailId) {
        this.name = name;
        this.emailId = emailId;
    }

    public Student(String name, String emailId, TableHistory tableHistory) {
        this.name = name;
        this.emailId = emailId;
        this.tableHistory = tableHistory;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public TableHistory getTableHistory() {
        return tableHistory;
    }

    public void setTableHistory(TableHistory tableHistory) {
        this.tableHistory = tableHistory;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", emailId='" + emailId + '\'' +
                ", tableHistory=" + tableHistory +
                '}';
    }
}

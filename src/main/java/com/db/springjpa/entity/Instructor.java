package com.db.springjpa.entity;

import javax.persistence.*;

@Entity
@Table(name = "tbl_instructor",schema = "spring_jpa")
public class Instructor {

    @Id
    @SequenceGenerator(
            name = "instructor_sequence",
            sequenceName = "instructor_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "instructor_sequence"
    )
    private Long instructorId;

    private String firstName;

    private String lastName;

   /* @OneToMany(
            cascade = CascadeType.ALL
    )
    // Here a new column would be added in Technology table with column name as "instructor_id"
    // After below code execution Technology table will be altered by addition of this column "instructor_id"
    // "instructor_id" serves as foreign key in Technology table
    // Hibernate: create table spring_jpa.tbl_instructor (instructor_id int8 not null, first_name varchar(255), last_name varchar(255), primary key (instructor_id))
    // Hibernate: alter table if exists spring_jpa.tbl_technology add constraint FKb9whlipaahb3eiys4xkh3kwun foreign key (instructor_id) references spring_jpa.tbl_instructor
    @JoinColumn(
            name = "instructor_id",
            referencedColumnName ="instructorId"
    )
    private List<Technology> technologies;*/

    public Instructor() {
    }

//    public Instructor(String firstName, String lastName
//            , List<Technology> technologies
//    ) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.technologies = technologies;
//    }

    public Instructor(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(Long instructorId) {
        this.instructorId = instructorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

//    public List<Technology> getTechnologies() {
//        return technologies;
//    }
//
//    public void setTechnologies(List<Technology> technologies) {
//        this.technologies = technologies;
//    }

    @Override
    public String toString() {
        return "Instructor{" +
                "instructorId=" + instructorId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
//                ", technologies=" + technologies +
                '}';
    }
}

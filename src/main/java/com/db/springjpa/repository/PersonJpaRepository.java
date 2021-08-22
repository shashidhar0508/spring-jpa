package com.db.springjpa.repository;

import com.db.springjpa.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonJpaRepository extends JpaRepository<Person,Long> {
}

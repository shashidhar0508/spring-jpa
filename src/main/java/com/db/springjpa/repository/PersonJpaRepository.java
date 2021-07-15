package com.db.springjpa.repository;

import com.db.springjpa.entity.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
//Whenever we insert or update rows to db, if we do three or 4 steps(transactions)
//        we want all of them to be successful or all of them to be failed together so we use @Transactional
public class PersonJpaRepository implements CrudRepository<Person, Integer> {


}

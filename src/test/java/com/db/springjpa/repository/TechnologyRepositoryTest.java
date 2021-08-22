package com.db.springjpa.repository;

import com.db.springjpa.entity.Technology;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TechnologyRepositoryTest {

    @Autowired
    private TechnologyRepository  technologyRepository;

    @Test
    public void showTechnologies(){
        List<Technology> all = technologyRepository.findAll();
        System.out.println("all = " + all);
    }
}
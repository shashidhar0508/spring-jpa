package com.db.springjpa.repository;

import com.db.springjpa.entity.TableHistory;
import com.db.springjpa.entity.Technology;
import com.db.springjpa.entity.TechnologyMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
class TechMaterialRepositoryTest {

    @Autowired
    private TechMaterialRepository techMaterialRepository;

    @Test
    public void saveTechMaterial(){

        TableHistory tableHistory = new TableHistory(
                "shashidhar",
                new Date(),
                "shashidhar",
                new Date()
        );

        Technology technology = new Technology(
                "DSA",
                6,
                tableHistory
        );

        TechnologyMaterial technologyMaterial = new TechnologyMaterial(
                "www.google.com",
                technology,
                tableHistory
        );

        TechnologyMaterial save = techMaterialRepository.save(technologyMaterial);
        System.out.println("save = " + save);
    }

    @Test
    public void showAllTechMaterials(){
        List<TechnologyMaterial> techMaterialRepositoryAll = techMaterialRepository.findAll();
        System.out.println("techMaterialRepositoryAll = " + techMaterialRepositoryAll);
    }
}
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

    @Test
    public void saveTechMaterialWithoutTech(){

        // This method will throw an error, We can't save Technology without TechMaterial
        // because we gave "optional=false" in mapping
        // We will get below error
        // not-null property references a null or transient value : com.db.springjpa.entity.TechnologyMaterial.technology;
        // nested exception is org.hibernate.PropertyValueException: not-null property references a null or transient value : com.db.springjpa.entity.TechnologyMaterial.technology

        TableHistory tableHistory = new TableHistory(
                "shashidhar",
                new Date(),
                "shashidhar",
                new Date()
        );

        Technology technology = new Technology(
                "DSA2",
                17,
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
}
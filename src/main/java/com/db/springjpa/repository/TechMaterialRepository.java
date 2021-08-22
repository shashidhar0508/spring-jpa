package com.db.springjpa.repository;

import com.db.springjpa.entity.TechnologyMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechMaterialRepository extends JpaRepository<TechnologyMaterial, Long> {
}

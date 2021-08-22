package com.db.springjpa.entity;

import javax.persistence.*;

@Entity
@Table(name = "tbl_technology",schema = "spring_jpa")
public class Technology {

    @Id
    @SequenceGenerator(
            name = "technology_sequence",
            sequenceName = "technology_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "technology_sequence"
    )
    private Long techId;
    private String name;
    private Integer credit;

    @OneToOne(
            mappedBy = "technology"     // For Bi-directional mapping
    )
    private TechnologyMaterial technologyMaterial;

    @Embedded
    private TableHistory tableHistory;

    public Technology() {
    }

    public Technology(String name, Integer credit, TableHistory tableHistory) {
        this.name = name;
        this.credit = credit;
        this.tableHistory = tableHistory;
    }

    public Long getTechId() {
        return techId;
    }

    public void setTechId(Long techId) {
        this.techId = techId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public TableHistory getTableHistory() {
        return tableHistory;
    }

    public void setTableHistory(TableHistory tableHistory) {
        this.tableHistory = tableHistory;
    }

    public TechnologyMaterial getTechnologyMaterial() {
        return technologyMaterial;
    }

    public void setTechnologyMaterial(TechnologyMaterial technologyMaterial) {
        this.technologyMaterial = technologyMaterial;
    }

    @Override
    public String toString() {
        return "Technology{" +
                "techId=" + techId +
                ", name='" + name + '\'' +
                ", credit=" + credit +
                ", technologyMaterial=" + technologyMaterial +
                ", tableHistory=" + tableHistory +
                '}';
    }
}

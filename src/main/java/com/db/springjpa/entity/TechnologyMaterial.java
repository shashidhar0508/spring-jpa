package com.db.springjpa.entity;

import javax.persistence.*;

@Entity
@Table(name = "tech_material",schema = "spring_jpa")
public class TechnologyMaterial {

    @Id
    @SequenceGenerator(
            name = "tech_material_sequence",
            sequenceName = "tech_material_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "tech_material_sequence"
    )
    private Long techMaterialId;
    private String url;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            optional = false    // Whenever we are saving "Technology" and the "TechnologyMaterial" is mandatory for it
                                // Which means "Technology" can't be saved now without "TechnologyMaterial"
                                // beDefault "optional" it is "True"
    )
    @JoinColumn(
            name = "tech_id",       // This is column name in TechnologyMaterial Table.
            referencedColumnName = "techId"       // It is referencing to techId in Technology table
    )
    private Technology technology;

    @Embedded
    private TableHistory tableHistory;

    public TechnologyMaterial() {
    }

    public TechnologyMaterial(String url, Technology technology, TableHistory tableHistory) {
        this.url = url;
        this.technology = technology;
        this.tableHistory = tableHistory;
    }

    public TechnologyMaterial(String url, TableHistory tableHistory) {
        this.url = url;
        this.tableHistory = tableHistory;
    }

    public Long getTechMaterialId() {
        return techMaterialId;
    }

    public void setTechMaterialId(Long techMaterialId) {
        this.techMaterialId = techMaterialId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Technology getTechnology() {
        return technology;
    }

    public void setTechnology(Technology technology) {
        this.technology = technology;
    }

    public TableHistory getTableHistory() {
        return tableHistory;
    }

    public void setTableHistory(TableHistory tableHistory) {
        this.tableHistory = tableHistory;
    }

    @Override
    public String toString() {
        return "TechnologyMaterial{" +
                "techMaterialId=" + techMaterialId +
                ", url='" + url + '\'' +
                ", tableHistory=" + tableHistory +
                '}';
    }
}

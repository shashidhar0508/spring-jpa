package com.db.springjpa.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Date;

@Embeddable     // To use in other classes like Parent child relationship
@AttributeOverrides({
        @AttributeOverride(
                name="createdBy",
                column = @Column(name = "createdBy")
        ),
        @AttributeOverride(
                name="createdOn",
                column = @Column(name = "createdOn")
        ),
        @AttributeOverride(
                name="updatedBy",
                column = @Column(name = "updatedBy")
        ),
        @AttributeOverride(
                name="updatedOn",
                column = @Column(name = "updatedOn")
        )
})
public class TableHistory {

    private String createdBy;
    private Date createdOn;
    private String updatedBy;
    private Date updatedOn;

    public TableHistory() {
    }

    public TableHistory(String createdBy, Date createdOn, String updatedBy, Date updatedOn) {
        this.createdBy = createdBy;
        this.createdOn = createdOn;
        this.updatedBy = updatedBy;
        this.updatedOn = updatedOn;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    @Override
    public String toString() {
        return "TableHistory{" +
                "createdBy='" + createdBy + '\'' +
                ", createdOn=" + createdOn +
                ", updatedBy='" + updatedBy + '\'' +
                ", updatedOn=" + updatedOn +
                '}';
    }
}

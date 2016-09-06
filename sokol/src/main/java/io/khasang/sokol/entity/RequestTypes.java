package io.khasang.sokol.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "REQUEST_TYPES")
@NamedQuery(name = "RequestTypes.findById", query = "SELECT DISTINCT r.title FROM RequestTypes r WHERE r.id = :id")
public class RequestTypes {
    @Id
    private int id;

    private  String title;

    private String description;

    private String createdDate;

    private String createdBy;

    private String updatedDate;

    private String updatedBy;

    @ManyToOne
    private Request request;

//    @ManyToOne
//    private Fields field;

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

//    public Fields getField() {
//        return field;
//    }

//    public void setField(Fields field) {
//        this.field = field;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String tittle) {
        this.title = tittle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getCreatedBy() {

        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}

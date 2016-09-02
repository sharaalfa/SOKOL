package io.khasang.sokol.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "REQUESTS")
@NamedQuery(name = "Request.findById", query = "SELECT DISTINCT r.title FROM Request r WHERE r.id = :id")
public class Request {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     int id;

    private  String title;

    private String description;

    private String assignedTo;

    private String version;

    private String requestTypeId;

    private String createdDate;

    private String createdBy;

    private String updatedDate;

    private String updatedBy;

    @OneToMany(mappedBy = "request")
    private Set<RequestTypes> requesttypes = new HashSet<>();

    public Set<RequestTypes> getRequesttypes() {
        return requesttypes;
    }

    public void setRequesttypes(Set<RequestTypes> requesttypes) {
        this.requesttypes = requesttypes;
    }

    public int getId() {
        return id;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getRequestTypeId() {
        return requestTypeId;
    }

    public void setRequestTypeId(String requestTypeId) {
        this.requestTypeId = requestTypeId;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
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


}

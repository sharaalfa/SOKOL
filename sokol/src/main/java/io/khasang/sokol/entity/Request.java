package io.khasang.sokol.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "REQUESTS")
@NamedQuery(name = "Request.findById", query = "SELECT DISTINCT r.title FROM Request r WHERE r.id = :id")
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REQUEST_ID")
    private Integer requestId;

    @Column(name = "TITLE")
    private  String title;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "ASSIGNED_TO")
    private String assignedTo;

    @Column(name = "REQUEST_TYPE_ID")
    private String requestTypeId;

    @Column(name = "CREATED_BY")
    private String createdBy;

    @Column(name = "UPDATED_BY")
    private String updatedBy;

    @ManyToOne
    private RequestTypes requestTypes;

    @Column(name = "CREATED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "UPDATED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;

    @Version
    private int version;

//    @OneToMany(mappedBy = "requestId")
//    private Set<FileldValues> fieldValuesSet = new HashSet<>();

    public Integer getRequestId() {
        return requestId;
    }

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
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

    public String getRequestTypeId() {
        return requestTypeId;
    }

    public void setRequestTypeId(String requestTypeId) {
        this.requestTypeId = requestTypeId;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public RequestTypes getRequestTypes() {
        return requestTypes;
    }

    public void setRequestTypes(RequestTypes requestTypes) {
        this.requestTypes = requestTypes;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

        public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getVersion() {
        return version;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
//
//    public Set<FileldValues> getFieldValuesSet() {
//        return fieldValuesSet;
//    }
//
//    public void setFieldValuesSet(Set<FileldValues> fieldValuesSet) {
//        this.fieldValuesSet = fieldValuesSet;
//    }
}

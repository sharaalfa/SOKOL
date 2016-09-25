package io.khasang.sokol.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "REQUESTS")
//@NamedQuery(name = "Request.findById", query = "SELECT DISTINCT r.title FROM Requests r WHERE r.id = :id")
public class Request extends  AuditableEntity {
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

    @ManyToOne
    @JoinColumn(name = "REQUEST_TYPE_ID")
    private RequestType requestType;

    @Version
    private int version;

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

    public void setVersion(int version) {
        this.version = version;
    }

    public int getVersion() {
        return version;
    }

}

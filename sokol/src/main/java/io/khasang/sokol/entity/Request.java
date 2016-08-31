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

    @ManyToOne
    private RequestTypes requestTypes;

    @OneToMany(mappedBy = "requestId")
    private Set<FileldValues> fieldValuesSet = new HashSet<>();



}

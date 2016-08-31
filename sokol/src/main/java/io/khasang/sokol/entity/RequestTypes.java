package io.khasang.sokol.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@NamedQuery(name = "RequestTypes.findById", query = "SELECT DISTINCT r FROM RequestTypes WHERE r.id = :id")

public class RequestTypes {
    @Id
    private int id;

    private  String tittle;

    private String description;

    private String createdDate;

    private String createdBy;

    private String updatedDate;

    private String updatedBy;

    @OneToMany(mappedBy = "requestType")
    Set<User> userSet = new HashSet<>();
}

package io.khasang.sokol.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "REQUEST_TYPES")
//@NamedQuery(name = "RequestTypes.findById", query = "SELECT DISTINCT r.title FROM REQUEST_TYPES r WHERE r.id = :id")
public class RequestType extends  AuditableEntity {
    @Id
    @Column(name = "REQUEST_TYPE_ID")
    private int id;

    @Column(name = "TITLE")
    private  String title;
    @Column(name = "DESCRIPTION")
    private String description;

    @OneToMany(mappedBy = "requestType", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Request> requests = new HashSet<>();

    @OneToMany(mappedBy = "requestType", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Field> fields = new HashSet<>();

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

}

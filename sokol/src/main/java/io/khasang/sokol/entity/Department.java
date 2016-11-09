package io.khasang.sokol.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "DEPARTMENTS")
public class Department extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "DEPARTMENT_ID")
    private int id;

    @Column(name = "TITLE")
    private String title;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RequestType> requestTypes = new ArrayList<>();

    public Department() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public List<RequestType> getRequestTypes() {
        return requestTypes;
    }

    public void addRequestType(RequestType requestType) {
        requestTypes.add(requestType);
        requestType.setDepartment(this);
    }

    public void removeRequestType(RequestType requestType) {
        requestTypes.remove(requestType);
        requestType.setDepartment(null);
    }
}

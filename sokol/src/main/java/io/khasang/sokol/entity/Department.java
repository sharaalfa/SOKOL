package io.khasang.sokol.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "DEPARTMENTS")
public class Department extends AuditableEntity {
    @Id
    private int id;
    @Column(name = "DEPART_NAME")
    private String name;

    @OneToMany(mappedBy = "department")
    Set<User> userSet = new HashSet();

    public Department() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

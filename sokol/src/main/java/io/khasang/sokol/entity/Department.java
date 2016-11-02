package io.khasang.sokol.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "DEPARTMENTS")
public class Department extends AuditableEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "DEPARTMENT_ID")
    private int id;

    @Column(name = "TITLE")
    private String title;

/*    @OneToMany(mappedBy = "department")
    Set<User> userSet = new HashSet<>();*/

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Request> requestSet = new HashSet<>();

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


}

package io.khasang.sokol.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
//@NamedQuery(name = "Role.findById", query = "select distinct r from Role r where r.id = :id")
@Table(name="ROLES")
public class Role extends AuditableEntity{
    @Id
    private int id;
    @Column(name = "ROLE_NAME")
    private String name;

    @Column(name = "ROLE_DESC")
    private String description;

    @OneToMany(mappedBy = "role")
    Set<User> userSet = new HashSet<>();

    public Role() {
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

    public Set<User> getUserSet() {
        return userSet;
    }

    public void setUserSet(Set<User> userSet) {
        this.userSet = userSet;
    }
}

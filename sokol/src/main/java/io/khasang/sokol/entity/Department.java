package io.khasang.sokol.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@IdClass(DepartmentKey.class)
public class Department {
    @Id
    private int id;

    private String name;
//    @Id
//    @AttributeOverride(
//            {
//                @AttributeOverride(name = "field", column =  @Column(name = "field"))
//                @AttributeOverride(name = "request", column =  @Column(name = "request"))
//            }
//    )
//    private int field;
//    private int request;

    @OneToMany(mappedBy = "department")
    Set<User> userSet = new HashSet();

    public Department() {
    }

//    public Department(DepartmentKey key){
//        field = key.getField();
//        request = key.getRequest();
//    }

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

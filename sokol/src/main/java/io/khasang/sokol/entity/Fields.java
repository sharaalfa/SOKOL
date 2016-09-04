package io.khasang.sokol.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "FIELDS")

public class Fields {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int field_id;

    String field_name;

    @OneToMany(mappedBy = "field")
    private Set<RequestTypes> requesttypes = new HashSet<>();


    public int getField_id() {
        return field_id;
    }

    public void setField_id(int field_id) {
        this.field_id = field_id;
    }

    public String getField_name() {
        return field_name;
    }

    public void setField_name(String field_name) {
        this.field_name = field_name;
    }


}


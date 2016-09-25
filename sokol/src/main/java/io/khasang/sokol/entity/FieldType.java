package io.khasang.sokol.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "FIELD_TYPES")
public class FieldType {
    @OneToMany(mappedBy = "fieldType", cascade = CascadeType.ALL, orphanRemoval = true)
    Set<Field> fieldSet = new HashSet<>();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FIELD_TYPE_ID")
    private Integer fieldTypeId;
    @Column(name = "FIELD_TYPE_NAME")
    private String fieldTypeName;

    public Set<Field> getFieldSet() {
        return fieldSet;
    }

    public Integer getFieldTypeId() {
        return fieldTypeId;
    }

    public void setFieldTypeId(Integer fieldTypeId) {
        this.fieldTypeId = fieldTypeId;
    }

    public String getFieldTypeName() {
        return fieldTypeName;
    }

    public void setFieldTypeName(String fieldTypeName) {
        this.fieldTypeName = fieldTypeName;
    }
}

package io.khasang.sokol.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class DepartmentKey implements Serializable{
    private int field;
    private int request;

    public DepartmentKey(int field, int request) {
        this.field = field;
        this.request = request;
    }

    public int getField() {
        return field;
    }

    public void setField(int field) {
        this.field = field;
    }

    public int getRequest() {
        return request;
    }

    public void setRequest(int request) {
        this.request = request;
    }
}

package io.khasang.sokol.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Andrey on 04.10.2016.
 */

@Entity
public class Temp extends  AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;


    private String name;

    public Temp() {


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

package io.khasang.sokol.entity;

import javax.persistence.*;

@Entity
public class FileldValues {

    @Id
    @ManyToOne
    @JoinColumn( name = "request_id")
    private Request requestId;
}

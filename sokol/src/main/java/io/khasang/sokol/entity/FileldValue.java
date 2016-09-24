package io.khasang.sokol.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "FIELD_VALUES")
public class FileldValue extends AuditableEntity {
    @Id
    private FileldValueKey fieldValueKey;

    @Column(name = "STRING_VALUE")
    private String stringValue;
    @Column(name = "NUMBER_VALUE")
    private Number numberValue;
    @Column(name = "DATE_VALUE")
    private Date dateValue;
}

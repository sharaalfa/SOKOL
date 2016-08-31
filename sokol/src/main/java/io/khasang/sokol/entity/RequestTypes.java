
package io.khasang.sokol.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "REQUEST_TYPES")

public class Requesttypes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int request_type_id;

    private String title;

    private String description;

    private String createdBy;

    private String updatedBy;

    @Temporal(TemporalType.DATE)
    private Date createDate;

    @Temporal(TemporalType.DATE)
    private Date updatedDate;

@OneToMany
//(mappedBy = "request_type_id")
 private Set<Request> requestSet = new HashSet<>();

    public int getRequest_type_id() {
        return request_type_id;
    }

    public void setRequest_type_id(int request_type_id) {
        this.request_type_id = request_type_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Requesttypes() {
        this.createDate = new Date();
    }




}









package io.khasang.sokol.entity;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "REQUESTS")

public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int request_id;

  //  private String description;

    public int getRequest_id() {
        return request_id;
    }

    public void setRequest_id(int request_id) {
        this.request_id = request_id;
    }

//    public String getDescription() {
  //      return description;
 //   }
@ManyToOne
private Requesttypes requesttypes;

    public Requesttypes getRequesttypes() {
        return requesttypes;
    }

    public void setRequesttypes(Requesttypes requesttypes) {
        this.requesttypes = requesttypes;
    }

    public Request() {
    }

  //    public void setDescription(String description) {
 //      this.description = description;
  //  }
  //  //  public Request() {
    //     this.createDate = new Date();

}

 /*   private String assigned_to;

    private Integer version;

    private String createdBy;

    private String updatedBy;

    @Temporal(TemporalType.DATE)
    private Date createDate;

    @Temporal(TemporalType.DATE)
    private Date updatedDate;



    public int getRequest_id() {
        return request_id;
    }

    public void setRequest_id(int request_id) {
        this.request_id = request_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAssigned_to() {
        return assigned_to;
    }

    public void setAssigned_to(String assigned_to) {
        this.assigned_to = assigned_to;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
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
    }*/






    //}
//}

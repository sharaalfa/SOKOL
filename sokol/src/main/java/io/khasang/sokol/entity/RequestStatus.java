package io.khasang.sokol.entity;

import javax.persistence.*;

@Entity
@Table(name = "REQUEST_STATUSES")
public class RequestStatus{
    @Id
    @Column(name = "REQUEST_STATUS_ID")
    private Integer requestStatusId;
    @Column(name = "REQUEST_STATUS_NAME")
    private String requestStatusName;

    public Integer getRequestStatusId() {
        return requestStatusId;
    }

    public void setRequestStatusId(Integer requestStatusId) {
        this.requestStatusId = requestStatusId;
    }

    public String getRequestStatusName() {
        return requestStatusName;
    }

    public void setRequestStatusName(String requestStatusName) {
        this.requestStatusName = requestStatusName;
    }
}




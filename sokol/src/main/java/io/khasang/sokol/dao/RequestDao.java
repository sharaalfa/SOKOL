package io.khasang.sokol.dao;

import io.khasang.sokol.entity.Request;

import java.util.List;

public interface RequestDao extends GenericDao<Request> {

    Request getByName(String name);


    Request getByRequestId(Integer requestId);
    List<Request> getMyRequests(String userName);
    List<Request>  getRequestsForMe(String userName);



}

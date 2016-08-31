package io.khasang.sokol.dao.impl;

import io.khasang.sokol.dao.RequestDao;
import io.khasang.sokol.entity.Request;
import org.springframework.stereotype.Repository;


@Repository
public class RequestDaoImpl extends GenericDaoImpl<Request> implements RequestDao{

    public RequestDaoImpl(){
        super(Request.class);

    }
    @Override
    public Request getByName(String name) {
        return null;
    }

    @Override
    public Request getById(Integer id) {
        return null;
    }

}

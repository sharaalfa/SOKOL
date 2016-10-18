package io.khasang.sokol.dao.impl;

import io.khasang.sokol.dao.RequestStatusDao;
import io.khasang.sokol.entity.RequestStatus;
import org.springframework.stereotype.Repository;

@Repository
public class RequestStatusDaoImpl extends GenericDaoImpl<RequestStatus> implements RequestStatusDao {
    public RequestStatusDaoImpl() {
        super(RequestStatus.class);
    }

    @Override
    public RequestStatus getById(Integer id) {
        return getSession().get(RequestStatus.class, id);
    }
}



package io.khasang.sokol.dao.impl;

import io.khasang.sokol.dao.RequestStatusDao;
import io.khasang.sokol.entity.RequestStatus;
import org.springframework.stereotype.Repository;

@Repository
public class RequestStatusDaoImpl extends GenericDaoImpl<RequestStatus, Integer> implements RequestStatusDao {
    public RequestStatusDaoImpl() {
        super(RequestStatus.class);
    }
}

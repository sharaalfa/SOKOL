package io.khasang.sokol.dao.impl;

import io.khasang.sokol.dao.RequestTypeDao;
import io.khasang.sokol.entity.RequestType;
import org.springframework.stereotype.Repository;

@Repository
public class RequestTypeDaoImpl extends GenericDaoImpl<RequestType, Integer> implements RequestTypeDao {
    public RequestTypeDaoImpl() {
        super(RequestType.class);
    }
}


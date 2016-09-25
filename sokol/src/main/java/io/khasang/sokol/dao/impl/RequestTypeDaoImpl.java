package io.khasang.sokol.dao.impl;

import io.khasang.sokol.dao.RequestTypeDao;
import io.khasang.sokol.entity.RequestType;

public class RequestTypeDaoImpl extends GenericDaoImpl<RequestType> implements RequestTypeDao {
    public RequestTypeDaoImpl(Class<RequestType> type) {
        super(type);
    }

    @Override
    public RequestType getById(Integer id) {
        return getSession().get(RequestType.class, id);
    }
}

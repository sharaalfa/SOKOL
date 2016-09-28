package io.khasang.sokol.dao;

import io.khasang.sokol.entity.RequestType;

public interface RequestTypeDao extends GenericDao<RequestType> {
    RequestType getById(Integer requestTypeId);
}

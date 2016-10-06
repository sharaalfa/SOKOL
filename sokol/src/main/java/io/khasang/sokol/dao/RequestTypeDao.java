package io.khasang.sokol.dao;

import io.khasang.sokol.entity.Request;
import io.khasang.sokol.entity.RequestType;

public interface RequestTypeDao extends GenericDao<RequestType> {
    RequestType getById(Integer requestTypeId);

    RequestType getByTitle(String title);
}

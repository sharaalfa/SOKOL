package io.khasang.sokol.dao;

import io.khasang.sokol.entity.Request;

public interface RequestDao extends GenericDao<Request>{

    Request getByName(String name);

    Request getByRequestId(Integer requestId);

}

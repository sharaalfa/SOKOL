package io.khasang.sokol.dao;

import io.khasang.sokol.entity.RequestTypes;

public interface RequestTypesDao extends GenericDao<RequestTypes> {
    RequestTypes getByTitle(String title);
}

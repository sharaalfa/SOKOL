package io.khasang.sokol.dao;

import io.khasang.sokol.entity.RequestStatus;
import io.khasang.sokol.entity.RequestType;

public interface RequestStatusDao extends GenericDao<RequestStatus> {
    RequestStatus getById(Integer requestTypeId);
}

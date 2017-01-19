package io.khasang.sokol.dao;

import io.khasang.sokol.entity.RequestStatus;

public interface RequestStatusDao extends GenericDao<RequestStatus, Integer> {
    RequestStatus getByRequestStatusId(Integer requestStatusId);
}


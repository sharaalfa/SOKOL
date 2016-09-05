package io.khasang.sokol.dao.impl;

import io.khasang.sokol.dao.GenericDao;
import io.khasang.sokol.dao.RequestTypesDao;
import io.khasang.sokol.entity.RequestTypes;
import org.springframework.stereotype.Repository;
import org.hibernate.criterion.Restrictions;

@Repository
public class RequestTypesDaoImpl extends GenericDaoImpl<RequestTypes> implements RequestTypesDao {
    public RequestTypesDaoImpl() {
        super(RequestTypes.class);
    }

    @Override
    public RequestTypes getByTitle(String title) {
        return (RequestTypes) getSession().createCriteria(RequestTypes.class)
                .add(Restrictions.eq("title", title)).uniqueResult();
    }


}
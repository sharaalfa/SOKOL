package io.khasang.sokol.dao.impl;

import io.khasang.sokol.dao.RequestTypeDao;
import io.khasang.sokol.entity.RequestType;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class RequestTypeDaoImpl extends GenericDaoImpl<RequestType> implements RequestTypeDao {
    public RequestTypeDaoImpl() {
        super(RequestType.class);
    }

    @Override
    public RequestType getById(Integer id) {
        return getSession().get(RequestType.class, id);
    }

    @Override
    public void update(RequestType requestType) {
        getSession().update(requestType);
    }

    @Override
    public RequestType getByTitle(String title) {
        return (RequestType) getSession().createCriteria(RequestType.class)
                .add(Restrictions.eq("title", title)).uniqueResult();
    }
}


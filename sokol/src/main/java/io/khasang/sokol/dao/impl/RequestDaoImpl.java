package io.khasang.sokol.dao.impl;

import io.khasang.sokol.dao.RequestDao;
import io.khasang.sokol.dao.RequestStatusDao;
import io.khasang.sokol.dao.RoleDao;
import io.khasang.sokol.dao.UserDao;
import io.khasang.sokol.entity.Request;
import io.khasang.sokol.entity.RequestStatus;
import io.khasang.sokol.entity.User;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RequestDaoImpl extends GenericDaoImpl<Request, Integer> implements RequestDao {
    public RequestDaoImpl() {
        super(Request.class);
    }

    @Autowired
    UserDao userDao;

    @Autowired
    RequestStatusDao requestStatusDao;

    @Override
    public Request getByRequestId(Integer requestId) {
        return getSession().get(Request.class, requestId);
    }

    @Override
    public List<Request>  getMyRequests(String userName) {
        User user = userDao.getByLogin(userName);
        RequestStatus statusClosed  = requestStatusDao.getById(3);
        RequestStatus statusCanceled  = requestStatusDao.getById(4);
        return (List<Request> ) getSession().createCriteria(Request.class)
                .add(Restrictions.eq("assignedTo", user))
                .add(Restrictions.ne("status",statusClosed))
                .add(Restrictions.ne("status",statusCanceled))
                .list();
    }

    @Override
    public List<Request> getRequestsForMe(String userName) {
        RequestStatus statusClosed  = requestStatusDao.getById(3);
        RequestStatus statusCanceled  = requestStatusDao.getById(4);
        return (List<Request> ) getSession().createCriteria(Request.class)
                .add(Restrictions.eq("createdBy", userName))
                .add(Restrictions.ne("status",statusClosed))
                .add(Restrictions.ne("status",statusCanceled))
                .list();
    }

    @Override
    public Request getByName(String name) {
        return (Request) getSession().createCriteria(Request.class)
                .add(Restrictions.eq("title", name))
                .uniqueResult();
    }
}

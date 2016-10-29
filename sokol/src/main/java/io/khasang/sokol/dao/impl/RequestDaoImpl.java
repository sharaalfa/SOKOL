package io.khasang.sokol.dao.impl;

import io.khasang.sokol.dao.RequestDao;
import io.khasang.sokol.dao.RoleDao;
import io.khasang.sokol.dao.UserDao;
import io.khasang.sokol.entity.Request;
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

    @Override
    public Request getByRequestId(Integer requestId) {
        return getSession().get(Request.class, requestId);
    }

    @Override
    public List<Request>  getMyRequests(String userName) {
        User user = userDao.getByLogin(userName);
        return (List<Request> ) getSession().createCriteria(Request.class)
                .add(Restrictions.eq("assignedTo", user))
                .list();
    }

    @Override
    public List<Request> getRequestsForMe(String userName) {
        return (List<Request> ) getSession().createCriteria(Request.class)
                .add(Restrictions.eq("createdBy", userName))
                .list();
    }

    @Override
    public Request getByName(String name) {
        return (Request) getSession().createCriteria(Request.class)
                .add(Restrictions.eq("name", name))
                .uniqueResult();
    }
}

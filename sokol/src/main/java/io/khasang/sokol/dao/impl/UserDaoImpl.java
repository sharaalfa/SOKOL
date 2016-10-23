package io.khasang.sokol.dao.impl;

import io.khasang.sokol.dao.UserDao;
import io.khasang.sokol.entity.Role;
import io.khasang.sokol.entity.User;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {
    public UserDaoImpl() {
        super(User.class);
    }


    @Override
    public User getById(Integer userId) {return getSession().get(User.class, userId);
    }



    @Override
    public User getByLogin(String login) {
        return (User) getSession().createCriteria(User.class)
                .add(Restrictions.eq("login", login)).uniqueResult();
    }

    @Override
    public User getByFio(String fio) {
        return (User) getSession().createCriteria(User.class)
                .add(Restrictions.eq("fio", fio)).uniqueResult();
    }
}

/*
    public RequestType getByTitle(String title) {
        return (RequestType) getSession().createCriteria(RequestType.class)
                .add(Restrictions.eq("title", title)).uniqueResult();
    }*/

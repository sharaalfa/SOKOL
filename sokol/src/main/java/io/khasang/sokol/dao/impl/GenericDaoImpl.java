package io.khasang.sokol.dao.impl;

import io.khasang.sokol.dao.GenericDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Transactional
public class GenericDaoImpl<T> implements GenericDao<T> {
    @Autowired
    private SessionFactory sessionFactory;

    private Class<T> type;

    public GenericDaoImpl(Class<T> type) {
        this.type = type;
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public int save(T object) {
        Serializable id = getSession().save(object);
        return (Integer) id;
    }

    @Override
    public void update(T object) {
        getSession().update(object);
    }

    @Override
    public void delete(T object) {
        getSession().delete(object);
    }

    @Override
    public List<T> getAll() {
        return getSession().createCriteria(type).list();
    }
}

package io.khasang.sokol.dao.impl;

import io.khasang.sokol.dao.GenericDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

@SuppressWarnings("unchecked")
@Transactional
public class GenericDaoImpl<T, K extends Serializable> implements GenericDao<T, K> {

    @Autowired
    private SessionFactory sessionFactory;

    private Class<? extends T> type;

    public GenericDaoImpl(Class<T> type) {
        this.type = type;
    }

    @SuppressWarnings("unchecked")
    public GenericDaoImpl() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        this.type = (Class) pt.getActualTypeArguments()[0];
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public K save(T entity) {
        return (K) getSession().save(entity);
    }

    @Override
    public void update(T entity) {
        getSession().update(entity);
    }

    @Override
    public void saveOrUpdate(T entity) {
        getSession().saveOrUpdate(entity);
    }

    @Override
    public void delete(T entity) {
        getSession().delete(entity);
    }

    @Override
    public T getById(K key) {
        return getSession().get(type, key);
    }

    @Override
    public List<T> getAll() {
        Query query = getSession().createQuery(String.format("from %s", type.getName()));
        return query.list();
    }
}

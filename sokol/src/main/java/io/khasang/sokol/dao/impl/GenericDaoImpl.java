package io.khasang.sokol.dao.impl;

import io.khasang.sokol.dao.GenericDao;
import io.khasang.sokol.entity.Request;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Transactional
public class GenericDaoImpl<T, K extends Serializable> implements GenericDao<T, K> {
    private Class<T> type;

    @Autowired
    private SessionFactory sessionFactory;

    public GenericDaoImpl(Class<T> type) {
        this.type = type;
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    @SuppressWarnings("unchecked")
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
    @SuppressWarnings("unchecked")
    public List<T> getAll() {
        Query query = getSession().createQuery(String.format("from %s", type.getName()));
        return query.list();
    }

    // firstLine + addLine - общее кол-во записей на странице
    public List<T> getPage(Integer firstLine, Integer addLine) {
        Query query = getSession().createQuery(String.format("from %s", type.getName()));
        query.setFirstResult(firstLine);
        query.setMaxResults(addLine);
        return query.list();
    }

    @Override
    public List<Request> sortingRequestByTitle(){
        Session session = getSession();
        String hql = "FROM Request f ORDER BY f.title ASC";
        Query query = session.createQuery(hql);
        return query.list();
    }
}

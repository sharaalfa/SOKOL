package io.khasang.sokol.dao;

import io.khasang.sokol.entity.Request;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T, K extends Serializable> {
    K save(T object);

    void update(T object);

    void saveOrUpdate(T object);

    void delete(T object);

    T getById(K key);

    List<T> getAll();

    List<T> getPage(Integer firstLine, Integer maxLine);

    List<Request> sortingRequestByID(Integer firstLine, Integer maxLine);

    List<Request> sortingRequestByDescription(Integer firstLine, Integer maxLine);

    List<Request> sortingRequestByTitle(Integer firstLine, Integer maxLine);

}

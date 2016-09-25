package io.khasang.sokol.dao;

import java.util.List;

public interface GenericDao<T> {
    int  save(T object);
    void delete(T object);
    List<T> getAll();
}

package io.khasang.sokol.dao;

import io.khasang.sokol.entity.Temp;

/**
 * Created by Andrey on 04.10.2016.
 */
public interface TempDao extends GenericDao<Temp>{
    Temp getById(Integer id);
}






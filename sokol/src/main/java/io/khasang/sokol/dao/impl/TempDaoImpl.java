package io.khasang.sokol.dao.impl;

import io.khasang.sokol.dao.TempDao;
import io.khasang.sokol.entity.Temp;
import org.springframework.stereotype.Repository;

/**
 * Created by Andrey on 04.10.2016.
 */

@Repository
public class TempDaoImpl extends GenericDaoImpl<Temp, Integer> implements TempDao {
    public TempDaoImpl() {
        super(Temp.class);
    }
}

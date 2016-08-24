package io.khasang.sokol.service;

import io.khasang.sokol.dao.impl.RoleDaoImpl;
import io.khasang.sokol.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleDaoImpl roleDao;

    public Role getById(Integer id){
        return roleDao.getById(id);
    }
    public Role getByName(String name){
        return null;
    }
}

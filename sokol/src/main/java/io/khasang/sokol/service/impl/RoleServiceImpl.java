package io.khasang.sokol.service.impl;

import io.khasang.sokol.dao.RoleDao;
import io.khasang.sokol.dao.impl.RoleDaoImpl;
import io.khasang.sokol.entity.Role;
import io.khasang.sokol.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

@Service
@CrossOrigin(origins = "*")
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleDao roleDao;

    public Role getById(Integer id) {
        return roleDao.getById(id);
    }

    public Role getByName(String name) {
        return null;
    }
}

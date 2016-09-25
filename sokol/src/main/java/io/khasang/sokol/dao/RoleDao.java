package io.khasang.sokol.dao;

import io.khasang.sokol.entity.Role;

public interface RoleDao extends GenericDao<Role> {
    Role getById(Integer id);

    Role getByName(String name);
}

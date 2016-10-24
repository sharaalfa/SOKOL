package io.khasang.sokol.dao;

import io.khasang.sokol.entity.Role;

import java.util.List;

public interface RoleDao extends GenericDao<Role> {
    Role getById(Integer id);

    Role getByName(String name);

    List<Role> getForRegisterForm();
}

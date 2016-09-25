package io.khasang.sokol.service;

import io.khasang.sokol.entity.Role;

public interface RoleService {
    Role getById(Integer id);

    Role getByName(String name);
}

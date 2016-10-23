package io.khasang.sokol.dao;

import io.khasang.sokol.entity.User;

public interface UserDao extends GenericDao<User> {
    User getByLogin(String login);
    User getByFio(String fio);
}

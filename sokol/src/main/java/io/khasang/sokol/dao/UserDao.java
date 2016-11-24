package io.khasang.sokol.dao;

import io.khasang.sokol.entity.Department;
import io.khasang.sokol.entity.User;

import java.util.List;

public interface UserDao extends GenericDao<User, Integer> {
    User getByLogin(String login);

    User getByFio(String fio);

    List<User> getUserListByDepartment(Department department);

    List<User> getUserListByUser(User user);
}

package io.khasang.sokol.dao;

import io.khasang.sokol.entity.Department;

public interface DepartmentDao extends GenericDao<Department> {
    Department getById(final int id);
}

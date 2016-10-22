package io.khasang.sokol.dao.impl;

import io.khasang.sokol.dao.DepartmentDao;
import io.khasang.sokol.entity.Department;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentDaoImpl extends GenericDaoImpl<Department> implements DepartmentDao {
    public DepartmentDaoImpl() {
        super(Department.class);
    }

    @Override
    public Department getById(int id) {
        return getSession().get(Department.class, id);
    }
}

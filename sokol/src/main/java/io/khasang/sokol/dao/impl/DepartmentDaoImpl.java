package io.khasang.sokol.dao.impl;

import io.khasang.sokol.dao.DepartmentDao;
import io.khasang.sokol.entity.Department;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentDaoImpl extends GenericDaoImpl<Department, Integer> implements DepartmentDao {
//    public DepartmentDaoImpl() {
//        super(Department.class);
//    }
}

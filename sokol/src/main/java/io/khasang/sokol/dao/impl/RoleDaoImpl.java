package io.khasang.sokol.dao.impl;

import io.khasang.sokol.dao.RoleDao;
import io.khasang.sokol.entity.Role;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleDaoImpl extends GenericDaoImpl<Role, Integer> implements RoleDao {
    public RoleDaoImpl() {
        super(Role.class);
    }

    @Override
    public Role getByName(String name) {
        return (Role) getSession().createCriteria(Role.class)
                .add(Restrictions.eq("name", name)).uniqueResult();
    }

    @Override
    public List<Role> getForRegisterForm() {
        return  (List<Role>) getSession().createCriteria(Role.class)
                .add(Restrictions.ne("name", "ROLE_ADMIN")).list();
    }
}

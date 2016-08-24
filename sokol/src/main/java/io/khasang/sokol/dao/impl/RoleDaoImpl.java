package io.khasang.sokol.dao.impl;

import io.khasang.sokol.dao.RoleDao;
import io.khasang.sokol.entity.Role;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl extends GenericDaoImpl<Role> implements RoleDao {

    public RoleDaoImpl(){
        super(Role.class);
    }

    @Override
    public Role getById(Integer id) {
        return getSession().get(Role.class, id);
        //return (Role) getSession().getNamedQuery("Role.findById").uniqueResult();
    }

    @Override
    public Role getByName(String name) {
        return (Role) getSession().createCriteria(Role.class)
                .add(Restrictions.eq("name", name)).uniqueResult();
    }
}

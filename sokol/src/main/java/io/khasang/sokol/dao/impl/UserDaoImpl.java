package io.khasang.sokol.dao.impl;

import io.khasang.sokol.dao.UserDao;
import io.khasang.sokol.entity.Department;
import io.khasang.sokol.entity.Role;
import io.khasang.sokol.entity.User;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl extends GenericDaoImpl<User, Integer> implements UserDao {
    public UserDaoImpl() {
        super(User.class);
    }

    @Override
    public User getByLogin(String login) {
        return (User) getSession().createCriteria(User.class)
                .add(Restrictions.eq("login", login)).uniqueResult();
    }

    @Override
    public User getByFio(String fio) {
        return (User) getSession().createCriteria(User.class)
                .add(Restrictions.eq("fio", fio)).uniqueResult();
    }

    @Override
    public List<User> getUserListByDepartment(Department department) {
        return (List<User>)getSession().createCriteria(User.class)
                .add(Restrictions.eq("department", department)).list();
    }

    @Override
    public List<User> getUserListByUser(User user){
        Role role = user.getRole();

        //Если пользователь администратор, то возвращаем всех
        if(role.getName().contains("ROLE_ADMIN") )
            return this.getAll();

        //Если пользователь менеджер, то возвращаем только пользователь его подразделения
        if(role.getName().contains("ROLE_MANAGER"))
            return this.getUserListByDepartment(user.getDepartment());

        return new ArrayList<User>();
    }
}

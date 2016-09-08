package io.khasang.sokol.config.db;


import io.khasang.sokol.dao.RoleDao;
import io.khasang.sokol.dao.UserDao;
import io.khasang.sokol.entity.Role;
import io.khasang.sokol.entity.User;
import org.osgi.service.component.annotations.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.logging.Logger;

@Component
public class AppInitialiser implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger log = Logger.getLogger("CreateTable");
    boolean alreadySetup = false;

    @Autowired
    UserDao userDao;
    @Autowired
    RoleDao roleDao;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (alreadySetup)
            return;

        Role admin_role = CheckForAdminRole();
        CheckForUserRole();
        CheckForAdminUser(admin_role);

        alreadySetup = true;
    }

    private Role CheckForUserRole() {
        Role admin_role  = roleDao.getByName("ROLE_USER");
        if(admin_role == null){
            admin_role = new Role();
            admin_role.setId(2);
            admin_role.setName("ROLE_USER");
            admin_role.setCreatedBy("SYSTEM");
            admin_role.setUpdatedBy("SYSTEM");
            roleDao.save(admin_role);
        }
        return  admin_role;
    }

    private Role CheckForAdminRole() {
        Role admin_role  = roleDao.getByName("ROLE_ADMIN");
        if(admin_role == null){
            admin_role = new Role();
            admin_role.setId(1);
            admin_role.setName("ROLE_ADMIN");
            admin_role.setCreatedBy("SYSTEM");
            admin_role.setUpdatedBy("SYSTEM");
            roleDao.save(admin_role);
        }
        return  admin_role;
    }

    private void CheckForAdminUser(Role admin_role) {

        User admin_user = userDao.getByLogin("admin");

        if(admin_user == null) {
            admin_user = new User();
            admin_user.setLogin("admin");
            admin_user.setFio("Adminisrator");
            admin_user.setEnabled(true);
            admin_user.setPassword(new BCryptPasswordEncoder().encode("admin"));
            admin_user.setEmail("admin@test.com");
            admin_user.setCreatedBy("SYSTEM");
            admin_user.setUpdatedBy("SYSTEM");
            admin_user.setRole(admin_role);
            userDao.save(admin_user);
        }
    }
}


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
        if (alreadySetup) {
            return;
        }
        Role adminRole = CheckForAdminRole();
        CheckForUserRole();
        CheckForAdminUser(adminRole);
        alreadySetup = true;
    }

    private Role CheckForUserRole() {
        Role adminRole = roleDao.getByName("ROLE_USER");
        if (adminRole == null) {
            adminRole = new Role();
            adminRole.setId(2);
            adminRole.setName("ROLE_USER");
            adminRole.setCreatedBy("SYSTEM");
            adminRole.setUpdatedBy("SYSTEM");
            roleDao.save(adminRole);
        }
        return adminRole;
    }

    private Role CheckForAdminRole() {
        Role admin_role = roleDao.getByName("ROLE_ADMIN");
        if (admin_role == null) {
            admin_role = new Role();
            admin_role.setId(1);
            admin_role.setName("ROLE_ADMIN");
            admin_role.setCreatedBy("SYSTEM");
            admin_role.setUpdatedBy("SYSTEM");
            roleDao.save(admin_role);
        }
        return admin_role;
    }

    private void CheckForAdminUser(Role admin_role) {
        User adminUser = userDao.getByLogin("admin");
        if (adminUser == null) {
            adminUser = new User();
            adminUser.setLogin("admin");
            adminUser.setFio("Adminisrator");
            adminUser.setEnabled(true);
            adminUser.setPassword(new BCryptPasswordEncoder().encode("admin"));
            adminUser.setEmail("admin@test.com");
            adminUser.setCreatedBy("SYSTEM");
            adminUser.setUpdatedBy("SYSTEM");
            adminUser.setRole(admin_role);
            userDao.save(adminUser);
        }
    }
}


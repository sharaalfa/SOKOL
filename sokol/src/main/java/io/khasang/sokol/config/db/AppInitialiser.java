package io.khasang.sokol.config.db;


import io.khasang.sokol.dao.RequestStatusDao;
import io.khasang.sokol.dao.RoleDao;
import io.khasang.sokol.dao.UserDao;
import io.khasang.sokol.entity.RequestStatus;
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
    RequestStatusDao requestStatusDao;
    @Autowired
    RoleDao roleDao;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (alreadySetup)
            return;

        Role admin_role = CheckForAdminRole();
        CheckForUserRole();
        CheckForManagerRole();
        CheckForAdminUser(admin_role);
        CheckForStatuses();
        alreadySetup = true;
    }
    private void CheckForStatuses()
    {
        RequestStatus status  = requestStatusDao.getById(1);
        if(status == null){
            status = new RequestStatus();
            status.setRequestStatusId(1);
            status.setRequestStatusName("Новая");
            requestStatusDao.save(status);
        }
        status  = requestStatusDao.getById(2);
        if(status == null){
            status = new RequestStatus();
            status.setRequestStatusId(2);
            status.setRequestStatusName("В заботе");
            requestStatusDao.save(status);
        }
        status  = requestStatusDao.getById(3);
        if(status == null){
            status = new RequestStatus();
            status.setRequestStatusId(3);
            status.setRequestStatusName("Закрыта");
            requestStatusDao.save(status);
        }
        status  = requestStatusDao.getById(4);
        if(status == null){
            status = new RequestStatus();
            status.setRequestStatusId(4);
            status.setRequestStatusName("Отклонена");
            requestStatusDao.save(status);
        }

    }
    private Role CheckForManagerRole() {
        Role roleManager  = roleDao.getByName("ROLE_MANAGER");
        if(roleManager == null){
            roleManager = new Role();
            roleManager.setId(3);
            roleManager.setDescription("Менеджер");
            roleManager.setName("ROLE_MANAGER");
            roleManager.setCreatedBy("SYSTEM");
            roleManager.setUpdatedBy("SYSTEM");
            roleDao.save(roleManager);
        }
        return  roleManager;
    }
    private Role CheckForUserRole() {
        Role admin_role  = roleDao.getByName("ROLE_USER");
        if(admin_role == null){
            admin_role = new Role();
            admin_role.setId(2);
            admin_role.setDescription("Сотрудник");
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
            admin_role.setDescription("Адмнистратор");
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


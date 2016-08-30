package dao;

import io.khasang.sokol.config.AppContext;
import io.khasang.sokol.config.security.AppSecurityConfig;
import io.khasang.sokol.config.db.HibernateConfig;
import io.khasang.sokol.config.application.WebConfig;
import io.khasang.sokol.dao.UserDao;
import io.khasang.sokol.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {AppContext.class, WebConfig.class, AppSecurityConfig.class, HibernateConfig.class})
public class TestUserDao {
    @Autowired
    UserDao userDao;

    @Test
    public void testGetByLogin(){
        User admin = userDao.getByLogin("admin");
        Assert.assertNotNull(admin);
        Assert.assertEquals("admin", admin.getLogin());
        Assert.assertEquals("admin", admin.getPassword());
        Assert.assertEquals("ROLE_ADMIN", admin.getRole().getName());
    }
}

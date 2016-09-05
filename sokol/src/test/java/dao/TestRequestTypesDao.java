package dao;

import io.khasang.sokol.config.AppContext;
import io.khasang.sokol.config.security.AppSecurityConfig;
import io.khasang.sokol.config.db.HibernateConfig;
import io.khasang.sokol.config.application.WebConfig;
import io.khasang.sokol.dao.RequestTypesDao;
import io.khasang.sokol.entity.RequestTypes;
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
public class TestRequestTypesDao {
    @Autowired
    RequestTypesDao requestTypesDao;

    @Test
    public void testGetByTitle(){
        RequestTypes title = requestTypesDao.getByTitle("title");
        Assert.assertNotNull(title);
        Assert.assertEquals("title", title.getRequest());
    }

}

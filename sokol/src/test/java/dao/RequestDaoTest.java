package dao;

import io.khasang.sokol.config.AppContext;
import io.khasang.sokol.config.application.WebConfig;
import io.khasang.sokol.config.db.HibernateConfig;
import io.khasang.sokol.config.security.AppSecurityConfig;
import io.khasang.sokol.dao.RequestDao;
import io.khasang.sokol.entity.Request;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {AppContext.class, WebConfig.class, AppSecurityConfig.class, HibernateConfig.class})
public class RequestDaoTest{
    @Autowired
    RequestDao requestDao;


    @Test
    public void testGetByName() throws Exception {
        Request request = requestDao.getByName("");
        Assert.assertNull(request);

    }

    @Test
    public void testGetByRequestId() throws Exception {
        Request request = requestDao.getByRequestId(0);
        Assert.assertNull(request);
    }
}
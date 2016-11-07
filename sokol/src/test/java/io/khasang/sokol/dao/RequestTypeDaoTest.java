package io.khasang.sokol.dao;

import io.khasang.sokol.config.AppContext;
import io.khasang.sokol.config.application.WebConfig;
import io.khasang.sokol.config.db.HibernateConfig;
import io.khasang.sokol.config.security.AppSecurityConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {AppContext.class, WebConfig.class, AppSecurityConfig.class, HibernateConfig.class})
public class RequestTypeDaoTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void save() throws Exception {

    }

    @Test
    public void update() throws Exception {

    }

    @Test
    public void saveOrUpdate() throws Exception {

    }

    @Test
    public void delete() throws Exception {

    }

    @Test
    public void getById() throws Exception {

    }

    @Test
    public void getAll() throws Exception {

    }

}
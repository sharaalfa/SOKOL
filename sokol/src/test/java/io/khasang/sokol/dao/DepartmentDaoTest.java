package io.khasang.sokol.dao;

import io.khasang.sokol.config.AppContext;
import io.khasang.sokol.config.application.TilesDefinitionsConfig;
import io.khasang.sokol.config.application.WebConfig;
import io.khasang.sokol.config.db.AppInitialiser;
import io.khasang.sokol.config.db.HibernateConfig;
import io.khasang.sokol.config.security.AppSecurityConfig;
import io.khasang.sokol.entity.Department;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(
        classes = {AppContext.class, WebConfig.class, AppSecurityConfig.class, HibernateConfig.class})
//@Transactional
public class DepartmentDaoTest extends AbstractTransactionalJUnit4SpringContextTests {
    public static String TITLE = "QWEASDZXC";
    public static String NEW_TITLE = "QWEASDZXCQWEASDZXC";
    private Department department;

    @Autowired
    DepartmentDao departmentDao;

    @Before
    public void setUp() throws Exception {
        department = new Department();
        department.setTitle(TITLE);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void saveAndDelete() throws Exception {
        int countBefore = departmentDao.getAll().size();
        int id = departmentDao.save(department);
        int countAfter = departmentDao.getAll().size();
        assertTrue(countBefore < countAfter);
        assertTrue(id > 0);
        Department loaded = departmentDao.getById(id);
        assertEquals(department.getTitle(), loaded.getTitle());
        departmentDao.delete(loaded);
        Department afterDelete = departmentDao.getById(id);
        assertNull(afterDelete);
    }

    @Test
    public void saveOrUpdateAndDelete() throws Exception {

    }
}
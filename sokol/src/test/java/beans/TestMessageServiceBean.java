package beans;

import io.khasang.sokol.beans.IMessageService;
import io.khasang.sokol.config.AppContext;
import io.khasang.sokol.config.application.WebConfig;
import io.khasang.sokol.config.db.HibernateConfig;
import io.khasang.sokol.config.security.AppSecurityConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {AppContext.class, WebConfig.class, AppSecurityConfig.class, HibernateConfig.class})
public class TestMessageServiceBean {
    @Autowired
    ApplicationContext context;

    @Test
    public void testGetInfo(){
//        IMessageService messageService = context.getBean("messageService", IMessageService.class);
//        Assert.assertNotNull(messageService);
//        Assert.assertEquals("Hello", messageService.getInfo());
    }
}

import beans.IMessageService;
import config.AppContext;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppContext.class})
public class TestMessageServiceBean {
    @Autowired
    ApplicationContext context;

    @Test
    public void testGetInfo(){
        IMessageService messageService = context.getBean("messageService", IMessageService.class);
        Assert.assertNotNull(messageService);
        Assert.assertEquals("Hello", messageService.getInfo());
    }
}

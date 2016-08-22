import io.khasang.sokol.beans.IMessageService;
import io.khasang.sokol.beans.impl.HelloMessage;
import io.khasang.sokol.config.AppContext;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppContext.class})
public class BeansTests {
    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void contentProviderTest() {
        IMessageService helloProviderBean = applicationContext.getBean("helloWorldProvider", HelloMessage.class);
        Assert.assertNotNull(helloProviderBean);
        helloProviderBean = (HelloMessage) applicationContext.getBean("helloWorldProvider");
        Assert.assertNotNull(helloProviderBean);
        Assert.assertEquals(helloProviderBean.getInfo(), "Hello");
    }
}

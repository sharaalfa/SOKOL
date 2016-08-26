package controller;

import io.khasang.sokol.config.AppContext;
import io.khasang.sokol.config.AppSecurityConfig;
import io.khasang.sokol.config.HibernateConfig;
import io.khasang.sokol.config.application.WebConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {AppContext.class, WebConfig.class, AppSecurityConfig.class, HibernateConfig.class})
public class TestAppController {
    @Autowired
    WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setup(){
        mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .build();
    }

    @Test
    public void testFirstRequestMapping() throws Exception{
//        mockMvc.perform(get("/login"))
//                .andExpect(status().isOk())
//                .andExpect(forwardedUrl("/WEB-INF/views/first.jsp"));
    }
}

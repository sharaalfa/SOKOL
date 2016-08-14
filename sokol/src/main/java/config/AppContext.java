package config;

import beans.IMessageService;
import beans.impl.HelloMessage;
import beans.impl.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppContext {
    @Bean(name = "messageService")
    public IMessageService message(){
        return new HelloMessage();
    }

    @Bean
    public User user(){
        return new User();
    }
}

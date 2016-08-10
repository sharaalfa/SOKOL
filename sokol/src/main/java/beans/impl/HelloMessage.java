package beans.impl;

import beans.IMessageService;
import org.springframework.stereotype.Component;

@Component
public class HelloMessage implements IMessageService {
    @Override
    public String getInfo() {
        return "Hello";
    }
}

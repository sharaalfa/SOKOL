package io.khasang.sokol.beans.impl;

import io.khasang.sokol.beans.IMessageService;
import org.springframework.stereotype.Component;

@Component
public class HelloMessage implements IMessageService {
    @Override
    public String getInfo() {
        return "Hello";
    }
}

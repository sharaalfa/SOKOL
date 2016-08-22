package io.khasang.sokol.beans.impl;

import io.khasang.sokol.beans.IMessageService;
import io.khasang.sokol.beans.IPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConsolePrinter implements IPrinter {
    @Autowired
    IMessageService messageService;

    @Override
    public void print() {
        System.out.println(messageService.getInfo());
    }
}

package beans.impl;

import beans.IMessageService;

public class MessageService implements IMessageService {
    private String message;

    public MessageService(String message) {
        this.message = message;
    }

    @Override
    public String getInfo() {
        return message;
    }
}

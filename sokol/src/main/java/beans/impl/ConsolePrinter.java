package beans.impl;
import beans.IMessageService;
import beans.IPrinter;

public class ConsolePrinter implements IPrinter {
    IMessageService message;
    String name;

    public ConsolePrinter(IMessageService message) {
        this.message = message;
    }

    @Override
    public void print() {
        System.out.println(message.getInfo());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

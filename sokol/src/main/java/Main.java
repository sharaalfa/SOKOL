import beans.IPrinter;
import beans.impl.ConsolePrinter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new FileSystemXmlApplicationContext("web/spring-dispatcher-servlet.xml");
        IPrinter printer = context.getBean("consolePrinter", ConsolePrinter.class);
        printer.print();
        IPrinter printer2 = context.getBean("consolePrinter", ConsolePrinter.class);
        if (context.getBean("stage") != null){
            System.out.println("bean created");
        }
    }
}

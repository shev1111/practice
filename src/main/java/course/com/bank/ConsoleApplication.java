package course.com.bank;

import course.com.bank.controller.MenuController;
import course.com.bank.injector.ApplicationInjector;
import course.com.bank.service.UserService;
import java.util.Arrays;
import java.util.List;

public class ConsoleApplication {
    public static void main(String[] args) {
        MenuController controller = new MenuController();
        controller.run();
    }
}
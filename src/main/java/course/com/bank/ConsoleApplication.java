package course.com.bank;


import course.com.bank.injector.ApplicationInjector;
import course.com.bank.service.UserService;

import java.util.Arrays;
import java.util.List;

public class ConsoleApplication {
    public static void main(String[] args) {
        final UserService userService = ApplicationInjector.getUserService();
        final boolean password = userService.login("alex@gmail.com", "password");
        System.out.println(password);

        List<String> list = Arrays.asList("one", "three", "five", "123456789");
        final Integer integer = list.stream()
                .map(String::length)
                .max(Integer::compareTo)
                .orElse(0);
        System.out.println(integer);
    }
}
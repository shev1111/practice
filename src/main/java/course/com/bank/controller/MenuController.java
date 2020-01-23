package course.com.bank.controller;

import course.com.bank.domain.User;
import course.com.bank.injector.ApplicationInjector;
import course.com.bank.service.UserService;
import course.com.bank.view.Commands;
import course.com.bank.view.InputData;
import course.com.bank.view.Multilingual;
import course.com.bank.view.View;
import static course.com.bank.view.Commands.CMD_QUIT;
import static course.com.bank.view.Commands.UA;
import static course.com.bank.view.Commands.ENG;

public class MenuController {
    private  UserService userService = ApplicationInjector.getUserService();
    private View view;

    public MenuController(){
        view = new View();
    }

    public void run(){
        initUserRepository();
        view.print(View.SELECT_LANGUAGE);
        view.print(View.SEPARATOR);
        selectLanguage();
        view.print(Multilingual.getResource().getString("welcome"));

        while (true) {
            String input = InputData.input().replaceAll("\\s+", " ").trim();

            if (CMD_QUIT.equals(input))return;

            if (input.matches(Commands.CMD_FIND_ALL_USERS)) {
                int pageNumber = Integer.parseInt(input.split("\\s")[1]);
                view.printCollection(userService.findAll(pageNumber).getItems());
            }
        }
    }

    private void selectLanguage() {
        while (true) {
            String input = InputData.input();
            input = input.trim();
            switch (input) {
                case UA:
                    Multilingual.switchLanguage(Multilingual.Language.UA);
                    return;
                case ENG:
                    Multilingual.switchLanguage(Multilingual.Language.ENG);
                    return;
                default:
                    if(input.equals(" ") || input.isEmpty()) {
                        break;
                    }
                    view.printErr("incorrect language");
                    view.println(View.SELECT_LANGUAGE);
            }
        }
    }

    private void initUserRepository(){
        for (int index = 0; index < 10 ; index++) {
          User user =   User.builder().withId(index).withEmail("test"+index+"@mail.com").
                    withPassword("password@01A"+index).
                    withTelephoneNumber("+38097544216"+index).
                    build();
            userService.register(user);

        }
    }
}

package course.com.bank.service.impl;

import course.com.bank.domain.User;
import course.com.bank.injector.ApplicationInjector;
import course.com.bank.service.UserService;


import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UserServiceImplTest {
    private static UserService userService;
    private static User validUser;
    private static User invalidUser;

    @BeforeClass
    public static void init(){
        userService = ApplicationInjector.getUserService();
        validUser = User.builder().withEmail("test@mail.com").withPassword("qwerty5678").withId(1).build();
        invalidUser = User.builder().withEmail("mail").withPassword("pass").withId(2).build();
    }


    @Test
    public void registerTest() throws Exception {
        assertTrue(userService.register(validUser));
        assertFalse(userService.register(invalidUser));
    }

    @Test
    public void loginTest() throws Exception {
        assertTrue(userService.register(validUser));
        assertTrue(userService.login("test@mail.com", "qwerty5678"));
    }

}
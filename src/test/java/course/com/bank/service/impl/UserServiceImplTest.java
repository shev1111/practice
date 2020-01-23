package course.com.bank.service.impl;

import course.com.bank.domain.User;
import course.com.bank.injector.ApplicationInjector;
import course.com.bank.service.UserService;
import course.com.bank.service.validator.ValidateException;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.Optional;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UserServiceImplTest {
    private static UserService userService;
    private static User validUser;
    private static User invalidUser;
    private static final String ENCRYPTED_PASSWORD = "y7c8avhnFMIAl+63EyHP+Q==";

    @BeforeClass
    public static void init(){
        userService = ApplicationInjector.getUserService();
        invalidUser = User.builder().withEmail("mail").withPassword("pass").withId(2).build();
    }

    @Before
    public void beforeTest(){
        validUser = User.builder().withEmail("test@mail.com").withPassword("password@01A").withId(1).withTelephoneNumber("+380975992054").build();
    }

    @Test
    public void registerTest() {
        Optional<User> userOptional = userService.register(validUser);
        assertTrue(userOptional.isPresent());
        User user = userOptional.get();
        assertEquals(user.getEmail(), validUser.getEmail());
        assertEquals(user.getPassword(), ENCRYPTED_PASSWORD);
    }

    @Test(expected = ValidateException.class)
    public void validateExceptionTest() {
        userService.register(invalidUser);
    }

    @Test
    public void loginTest() throws Exception {
        Optional<User> userOptional = userService.register(validUser);
        assertTrue(userOptional.isPresent());
        assertTrue(userService.login("test@mail.com", "password@01A"));
        assertFalse(userService.login("test@mail.com", "qwerty5678"));
    }

}
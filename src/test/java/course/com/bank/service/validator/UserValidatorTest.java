package course.com.bank.service.validator;

import course.com.bank.domain.User;
import course.lessons.lesson1.tester.annotations.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserValidatorTest {
    private static User validUser = User.builder().withEmail("test@mail.com").withPassword("password").build();
    private static User invalidUser = User.builder().withEmail("testmail.com").withPassword("").build();
    private static UserValidator userValidator = new UserValidator();

    @Test
    public void validateTest() {
        assertTrue(userValidator.validate(validUser));
        assertFalse(userValidator.validate(invalidUser));
    }

}
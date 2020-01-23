package course.com.bank.service.validator;

import course.com.bank.domain.User;
import course.lessons.lesson1.tester.annotations.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserValidatorTest {
    private static User invalidUser = User.builder().withEmail("testmail.com").withPassword("").withTelephoneNumber("+589674").build();
    private static UserValidator userValidator = new UserValidator();

   @Test(expected = ValidateException.class )
    public void validateExceptionTest() {
        userValidator.validate(invalidUser);
    }

}
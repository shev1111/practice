package course.com.bank.service.validator;

import course.com.bank.domain.User;
import java.util.function.Function;
import java.util.regex.Pattern;

public class UserValidator implements Validator<User> {
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[a-zA-Z0-9_!#$%&*+/=?`{}~^.-]+@[a-zA-Z0-9.-]+$");
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})");
    private static final Pattern TELEPHONE_PATTERN = Pattern.compile("([+]*38[(]?[0-9]{1,4}[)]?[-\\s./0-9]*)");

    @Override
    public void validate(User user) {
        if (user == null) {
            throw new ValidateException("");
        }
        validateEmail(user);
        validatePassword(user);
        validateString(TELEPHONE_PATTERN, user, User::getTelephoneNumber, "Telephone do not match the pattern");
    }

    private static void validateEmail(User user){
        validateString(EMAIL_PATTERN, user, User::getEmail, "Email do not match the pattern");
    }

    private static void validatePassword(User user){
        validateString(PASSWORD_PATTERN, user, User::getPassword, "Password do not match the pattern");
    }

    private static void validateString(Pattern pattern, User user, Function<User, String> function,
                                       String exceptionMessage) {
        if (!pattern.matcher(function.apply(user)).matches()) {
            throw new ValidateException(exceptionMessage);
        }
    }
}

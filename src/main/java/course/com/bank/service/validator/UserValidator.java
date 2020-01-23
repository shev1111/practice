package course.com.bank.service.validator;

import course.com.bank.domain.User;

public class UserValidator implements Validator<User> {

    @Override
    public boolean validate(User entity) {
        return  entity != null &&
                entity.getEmail().matches("^(.+)@(.+)$") &&
                entity.getPassword().matches("^.{8,}$");
    }
}

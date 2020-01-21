package course.com.bank.injector;

import course.com.bank.domain.User;
import course.com.bank.repository.UserRepository;
import course.com.bank.repository.impl.UserRepositoryImpl;
import course.com.bank.service.UserService;
import course.com.bank.service.impl.UserServiceImpl;
import course.com.bank.service.security.Encryption;
import course.com.bank.service.security.TripleDes;
import course.com.bank.service.validator.UserValidator;
import course.com.bank.service.validator.Validator;

public class ApplicationInjector  {
    private static final ApplicationInjector INSTANCE =  new ApplicationInjector();

    private static final Validator<User> VALIDATOR =  new UserValidator();

    private static final Encryption PASSWORD_ENCRYPTION =  new TripleDes();

    private static final UserRepository USER_REPOSITORY =  new UserRepositoryImpl();

    private static final UserService USER_SERVICE =  new UserServiceImpl(USER_REPOSITORY, PASSWORD_ENCRYPTION, VALIDATOR);

    public ApplicationInjector() {
    }

    public static ApplicationInjector getInstance() {
        return INSTANCE;
    }

    public static UserService getUserService() {
        return USER_SERVICE;
    }
}

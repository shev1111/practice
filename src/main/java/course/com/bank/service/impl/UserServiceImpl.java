package course.com.bank.service.impl;

import course.com.bank.domain.User;
import course.com.bank.repository.UserRepository;
import course.com.bank.service.UserService;
import course.com.bank.service.security.Encryption;
import course.com.bank.service.validator.Validator;
import java.util.Optional;

public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;
  private final Encryption passwordEncryption;
  private final Validator<User> userValidator;


    public UserServiceImpl(UserRepository userRepository, Encryption passwordEncryptor, Validator<User> userValidator) {
        this.userRepository = userRepository;
        this.passwordEncryption = passwordEncryptor;
        this.userValidator = userValidator;
    }


    @Override
    public boolean login(String email, String password){
        String encryptPassword = passwordEncryption.encrypt(password);

        return userRepository.findByEmail(email)
                .map(User::getPassword)
                .filter(pass->pass.equals(encryptPassword))
                .isPresent();
    }

    @Override
    public Optional<User> register (User user){
        userValidator.validate(user);
        user.setPassword(passwordEncryption.encrypt(user.getPassword()));
        userRepository.save(user);
        return userRepository.findByEmail(user.getEmail());
    }
}

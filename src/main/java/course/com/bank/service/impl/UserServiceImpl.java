package course.com.bank.service.impl;

import course.com.bank.domain.User;
import course.com.bank.exeception.EncryptionException;
import course.com.bank.repository.UserRepository;
import course.com.bank.service.UserService;
import course.com.bank.service.security.Encryption;
import course.com.bank.service.validator.Validator;

public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;
  private final Encryption passwordEncryption;
  private final Validator<User> userValidator;


    public UserServiceImpl(UserRepository userRepository, Encryption passwordEncryptor, Validator<User> userValidator) {
        this.userRepository = userRepository;
        this.passwordEncryption = passwordEncryptor;
        this.userValidator = userValidator;
    }



    public boolean login(String email, String password){
        String encryptPassword;

        try {
             encryptPassword = passwordEncryption.encrypt(password);
        } catch (EncryptionException e) {
            return false;
        }

        return userRepository.findByEmail(email)
                .map(x->x.getPassword())
                .filter(x->x.equals(encryptPassword))
                .isPresent();

    }

    public User register (User user){
        if(userValidator.validate(user)){
            userRepository.save(user);
        }

        return user;
    }
}
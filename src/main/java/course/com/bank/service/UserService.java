package course.com.bank.service;

import course.com.bank.domain.User;

import java.util.Optional;

public interface UserService {

    boolean login(String email, String password);

    Optional<User> register(User user);
}

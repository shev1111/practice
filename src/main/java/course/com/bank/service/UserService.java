package course.com.bank.service;

import course.com.bank.domain.User;

public interface UserService {

    boolean login(String email, String password);

    User register(User user);
}

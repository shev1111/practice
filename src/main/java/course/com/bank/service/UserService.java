package course.com.bank.service;

import course.com.bank.domain.User;
import course.com.bank.repository.Pageable;

import java.util.List;
import java.util.Optional;

public interface UserService {

    boolean login(String email, String password);

    Optional<User> register(User user);

    Pageable<User> findAll(int page);
}

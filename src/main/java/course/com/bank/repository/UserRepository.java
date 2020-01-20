package course.com.bank.repository;


import course.com.bank.domain.User;

public interface UserRepository extends CrudRepository<User> {

    User findByEmail(String email);
}

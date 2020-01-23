package course.com.bank.repository.impl;



import course.com.bank.domain.User;
import course.com.bank.repository.UserRepository;

import java.util.*;

public class UserRepositoryImpl implements UserRepository {

    private final Map<Integer, User> userIdToUser = new HashMap<>();



    @Override
    public Optional<User> findByEmail(String email) {
        Optional<User> userOptional;
        userOptional = userIdToUser.values().stream().filter(user -> user.getEmail().equals(email)).findAny();

        return userOptional;
    }

    @Override
    public void save(User entity) {
        userIdToUser.put(entity.getId(),entity);
    }

    @Override
    public Optional<User> findById(Integer id) {
        return Optional.ofNullable(userIdToUser.get(id));
    }

    @Override
    public List<User> findAll(int page, int itemsPerPage) {
        //pagination
        return new ArrayList<>(userIdToUser.values());
    }

    @Override
    public void update(User entity) {
        if(entity!=null&&entity.getId()!=null){
            userIdToUser.put(entity.getId(), entity);
        }

    }

    @Override
    public void deleteById(Integer id) {
        userIdToUser.remove(id);
    }

    @Override
    public long count() {
        return userIdToUser.size();
    }
}

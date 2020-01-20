package course.com.bank.repository.impl;



import course.com.bank.domain.User;
import course.com.bank.repository.UserRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {
    private static final User DEFAULT_USER;
    private final Map<Integer, User> userIdToUser = new HashMap<>();

    static {
        DEFAULT_USER = User.builder()
                .withEmail("no email")
                .withPassword("password")
                .withAccounts(null)
                .build();
    }

    @Override
    public User findByEmail(String email) {
        Optional<User> userOptional;
        userOptional = userIdToUser.entrySet().
                stream().
                filter(element -> element.getValue().getEmail().equals(email)).
                findFirst().
                map(Map.Entry::getValue);
        return userOptional.orElse(DEFAULT_USER);
    }

    @Override
    public void save(User entity) {
        if(entity!=null){
            userIdToUser.put(entity.getId(),entity);
        }


    }

    @Override
    public User findById(Integer id) {
        Optional<User> userOptional = Optional.ofNullable(userIdToUser.get(id));
        return userOptional.orElse(DEFAULT_USER);
    }

    @Override
    public List<User> findAll() {
        return (List<User>) userIdToUser.values();
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
}

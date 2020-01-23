package course.com.bank.repository.impl;

import course.com.bank.domain.User;
import course.com.bank.repository.Page;
import course.com.bank.repository.Pageable;
import course.com.bank.repository.UserRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public Pageable<User> findAll(Page page) {
        int userNumberToSkip = page.getPageNumber()*page.getItemsPerPage()-page.getItemsPerPage();

        List<User> users = userIdToUser.values().stream().
                skip(userNumberToSkip).
                limit(page.getItemsPerPage()).
                collect(Collectors.toList());
        int maxPageNumber = userIdToUser.size()/page.getItemsPerPage();

        return new Pageable<>(users, page, maxPageNumber);
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
    public int count() {
        return userIdToUser.size();
    }
}

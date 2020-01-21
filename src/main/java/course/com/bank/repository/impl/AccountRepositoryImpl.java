package course.com.bank.repository.impl;

import course.com.bank.domain.Account;
import course.com.bank.repository.AccountRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class AccountRepositoryImpl implements AccountRepository {

    private final Map<Integer, Account> accountIdToAccount = new HashMap<>();


    @Override
    public void save(Account entity) {
        if(entity!=null){
            accountIdToAccount.put(entity.getId(),entity);
        }
    }

    @Override
    public Optional<Account> findById(Integer id) {
        return Optional.ofNullable(accountIdToAccount.get(id));
    }

    @Override
    public List<Account> findAll() {
        return (List<Account>) accountIdToAccount.values();
    }

    @Override
    public void update(Account entity) {
        if(entity!=null && entity.getId()!=null){
            accountIdToAccount.put(entity.getId(),entity);
        }

    }

    @Override
    public void deleteById(Integer id) {
        accountIdToAccount.remove(id);
    }
}

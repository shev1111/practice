package course.com.bank.repository.impl;

import course.com.bank.domain.Account;
import course.com.bank.repository.AccountRepository;
import course.com.bank.repository.Page;
import course.com.bank.repository.Pageable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public Pageable<Account> findAll(Page page) {
        int userNumberToSkip = page.getPageNumber()*page.getItemsPerPage()-page.getItemsPerPage();
        List<Account> accounts = accountIdToAccount.values().stream().
                skip(userNumberToSkip).
                limit(page.getItemsPerPage()).
                collect(Collectors.toList());
        int maxPageNumber = accountIdToAccount.size()/page.getItemsPerPage();
        return new Pageable<>(accounts, page, maxPageNumber);
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

    @Override
    public long count() {
        return accountIdToAccount.size();
    }
}

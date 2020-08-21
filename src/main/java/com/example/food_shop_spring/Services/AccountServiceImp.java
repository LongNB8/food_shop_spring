package com.example.food_shop_spring.Services;

import com.example.food_shop_spring.Models.Account;
import com.example.food_shop_spring.Repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class AccountServiceImp implements AccountService {
    @Autowired
    private AccountRepository accountRepository;


    @Override
    public Account findByEmailOrUsername(String emailOrUsername) {
        return accountRepository.findByEmailOrUsername(emailOrUsername, emailOrUsername);
    }

    @Override
    public Account findByUsername(String username) {
        return accountRepository.findByUsername(username);
    }

    @Override
    public <S extends Account> S save(S s) {
        return accountRepository.save(s);
    }

    @Override
    public Optional<Account> findById(Integer integer) {
        return accountRepository.findById(integer);
    }

    @Override
    public void deleteById(Integer integer) {
        accountRepository.deleteById(integer);
    }
}

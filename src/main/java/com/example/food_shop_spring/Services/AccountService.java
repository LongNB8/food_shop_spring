package com.example.food_shop_spring.Services;

import com.example.food_shop_spring.Models.Account;

import java.util.Optional;

public interface AccountService {

    Account findByEmailOrUsername(String emailOrUsername);
    public Account findByUsername(String username);

    <S extends Account> S save(S s);

    Optional<Account> findById(Integer integer);

    void deleteById(Integer integer);
}

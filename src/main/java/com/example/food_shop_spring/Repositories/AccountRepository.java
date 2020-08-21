package com.example.food_shop_spring.Repositories;

import com.example.food_shop_spring.Models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {
    public Account findByUsername(String username);

    Account findByEmailOrUsername(String email, String username);
}

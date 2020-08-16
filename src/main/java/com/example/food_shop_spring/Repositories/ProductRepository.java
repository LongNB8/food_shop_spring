package com.example.food_shop_spring.Repositories;

import com.example.food_shop_spring.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}

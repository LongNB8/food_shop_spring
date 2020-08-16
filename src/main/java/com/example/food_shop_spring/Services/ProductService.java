package com.example.food_shop_spring.Services;

import com.example.food_shop_spring.Models.Category;
import com.example.food_shop_spring.Models.Product;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    public List<Product> findAll();
    <S extends Product> S save(S s);

    Optional<Product> findById(Integer integer);

    void deleteById(Integer integer);
}

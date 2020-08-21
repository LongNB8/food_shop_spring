package com.example.food_shop_spring.Services;

import com.example.food_shop_spring.Models.Category;
import com.example.food_shop_spring.Models.Product;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    int CountPr();
    List<Product> searchAll(String keyword,boolean status, int n);
    List<Product> findByCategoryId(int category_id);
    List<Product> ListNewProduct(int n);
    public List<Product> findAll();
    Page<Product> findAllPro(Pageable pageable);
    <S extends Product> S save(S s);

    Optional<Product> findById(Integer integer);

    void deleteById(Integer integer);
    List<Product> findAll1();

    <S extends Product> long count(Example<S> example);
}

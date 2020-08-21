package com.example.food_shop_spring.Repositories;

import com.example.food_shop_spring.Models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("FROM Product where category_id = :category_id")
    List<Product> findByCategoryId(int category_id);

    @Query("from Product ")
    List<Product> findAll1();

    @Query("select p from Product p")
    Page<Product> findAllPro(Pageable pageable);

    @Query("select count(p.id) from Product p")
    int CountPr();

}

package com.example.food_shop_spring.Repositories;

import com.example.food_shop_spring.Models.PhotoPr;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface PhotoPrRepository extends CrudRepository<PhotoPr, Integer> {
    @Query("from PhotoPr where  product_id = :product_id and main = :main")
    List<PhotoPr> findByProductId(int product_id, boolean main);
}

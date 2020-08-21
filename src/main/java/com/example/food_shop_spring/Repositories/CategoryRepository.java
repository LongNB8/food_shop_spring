package com.example.food_shop_spring.Repositories;

import com.example.food_shop_spring.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Query("from Category where  category_parent_id = null")
    List<Category> findByParentCategory();

    @Query("from Category where category_parent_id = :category_id")
    List<Category> listSubCategory(int category_id);

    @Query(value = "select * from category where status = :status order by id limit :n", nativeQuery = true)
    List<Category> listCategoryOur(@Param("status") boolean status, @Param("n") int n);
}




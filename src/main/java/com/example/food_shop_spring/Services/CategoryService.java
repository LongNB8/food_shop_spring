package com.example.food_shop_spring.Services;

import com.example.food_shop_spring.Models.Category;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<Category> listSubCategory(int category_id);

    List<Category> findByParentCategory();

    List<Category> findAll();

    List<Category> findAll(Sort sort);

    List<Category> findAllById(Iterable<Integer> iterable);

    <S extends Category> List<S> saveAll(Iterable<S> iterable);

    <S extends Category> List<S> findAll(Example<S> example);

    <S extends Category> S save(S s);

    Optional<Category> findById(Integer integer);

    void deleteById(Integer integer);

    void delete(Category category);

    void deleteAll(Iterable<? extends Category> iterable);

    void deleteAll();
}

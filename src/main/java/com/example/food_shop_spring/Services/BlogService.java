package com.example.food_shop_spring.Services;

import com.example.food_shop_spring.Models.Blog;
import org.springframework.data.domain.Example;

import java.util.List;
import java.util.Optional;

public interface BlogService {
    public List<Blog> findAll();

    <S extends Blog> S save(S s);

    Optional<Blog> findById(Integer integer);

    void deleteById(Integer integer);
}

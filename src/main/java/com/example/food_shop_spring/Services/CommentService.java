package com.example.food_shop_spring.Services;

import com.example.food_shop_spring.Models.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentService {
    List<Comment> findByBlogId(int blog_id);
    List<Comment> findByParentId(int parent_id);

    List<Comment> findAll();

    <S extends Comment> S save(S s);

    Optional<Comment> findById(Integer integer);

    void deleteById(Integer integer);
}

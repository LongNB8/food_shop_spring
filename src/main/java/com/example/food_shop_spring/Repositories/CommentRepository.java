package com.example.food_shop_spring.Repositories;

import com.example.food_shop_spring.Models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

    @Query("from Comment where blog_id = :blog_id and parent_id = null")
    List<Comment> findByBlogId(int blog_id);

    @Query("from Comment where parent_id = :parent_id")
    List<Comment> findByParentCommentId(int parent_id);
}

package com.example.food_shop_spring.Repositories;

import com.example.food_shop_spring.Models.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
}

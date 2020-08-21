package com.example.food_shop_spring.Services;

import com.example.food_shop_spring.Models.Blog;
import com.example.food_shop_spring.Repositories.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BlogServiceImp implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public <S extends Blog> S save(S s) {
        return blogRepository.save(s);
    }

    @Override
    public Optional<Blog> findById(Integer integer) {
        return blogRepository.findById(integer);
    }

    @Override
    public void deleteById(Integer integer) {
        blogRepository.deleteById(integer);
    }

    public List<Blog> findAll() {
        return blogRepository.findAll();
    }
}

package com.example.food_shop_spring.Services;

import com.example.food_shop_spring.Models.Comment;
import com.example.food_shop_spring.Repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CommentServiceImp implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<Comment> findByBlogId(int blog_id) {
        return commentRepository.findByBlogId(blog_id);
    }

    @Override
    public List<Comment> findByParentId(int parent_id) {
        return commentRepository.findByParentCommentId(parent_id);
    }

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public <S extends Comment> S save(S s) {
        return commentRepository.save(s);
    }

    @Override
    public Optional<Comment> findById(Integer integer) {
        return commentRepository.findById(integer);
    }

    @Override
    public void deleteById(Integer integer) {
        commentRepository.deleteById(integer);
    }
}

package com.example.food_shop_spring.Services;


import com.example.food_shop_spring.Models.Category;
import com.example.food_shop_spring.Repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class CategoryServiceImp implements  CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> listSubCategory(int category_id) {
        return categoryRepository.listSubCategory(category_id);
    }

    @Override
    public List<Category> findByParentCategory(){
        return categoryRepository.findByParentCategory();
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public List<Category> findAll(Sort sort) {
        return categoryRepository.findAll(sort);
    }

    @Override
    public List<Category> findAllById(Iterable<Integer> iterable) {
        return categoryRepository.findAllById(iterable);
    }

    @Override
    public <S extends Category> List<S> saveAll(Iterable<S> iterable) {
        return categoryRepository.saveAll(iterable);
    }

    public void flush() {
        categoryRepository.flush();
    }

    public <S extends Category> S saveAndFlush(S s) {
        return categoryRepository.saveAndFlush(s);
    }

    public void deleteInBatch(Iterable<Category> iterable) {
        categoryRepository.deleteInBatch(iterable);
    }

    public void deleteAllInBatch() {
        categoryRepository.deleteAllInBatch();
    }

    public Category getOne(Integer integer) {
        return categoryRepository.getOne(integer);
    }

    @Override
    public <S extends Category> List<S> findAll(Example<S> example) {
        return categoryRepository.findAll(example);
    }

    public <S extends Category> List<S> findAll(Example<S> example, Sort sort) {
        return categoryRepository.findAll(example, sort);
    }

    public Page<Category> findAll(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    @Override
    public <S extends Category> S save(S s) {
        return categoryRepository.save(s);
    }

    @Override
    public Optional<Category> findById(Integer integer) {
        return categoryRepository.findById(integer);
    }

    public boolean existsById(Integer integer) {
        return categoryRepository.existsById(integer);
    }

    public long count() {
        return categoryRepository.count();
    }

    @Override
    public void deleteById(Integer integer) {
        categoryRepository.deleteById(integer);
    }

    @Override
    public void delete(Category category) {
        categoryRepository.delete(category);
    }

    @Override
    public void deleteAll(Iterable<? extends Category> iterable) {
        categoryRepository.deleteAll(iterable);
    }

    @Override
    public void deleteAll() {
        categoryRepository.deleteAll();
    }

    public <S extends Category> Optional<S> findOne(Example<S> example) {
        return categoryRepository.findOne(example);
    }

    public <S extends Category> Page<S> findAll(Example<S> example, Pageable pageable) {
        return categoryRepository.findAll(example, pageable);
    }

    public <S extends Category> long count(Example<S> example) {
        return categoryRepository.count(example);
    }

    public <S extends Category> boolean exists(Example<S> example) {
        return categoryRepository.exists(example);
    }
}

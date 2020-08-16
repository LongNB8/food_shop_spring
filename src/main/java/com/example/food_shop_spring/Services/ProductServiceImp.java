package com.example.food_shop_spring.Services;

import com.example.food_shop_spring.Models.Product;
import com.example.food_shop_spring.Repositories.ProductRepository;
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
public class ProductServiceImp implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public List<Product> findAll(Sort sort) {
        return productRepository.findAll(sort);
    }

    public List<Product> findAllById(Iterable<Integer> iterable) {
        return productRepository.findAllById(iterable);
    }

    public <S extends Product> List<S> saveAll(Iterable<S> iterable) {
        return productRepository.saveAll(iterable);
    }

    public void flush() {
        productRepository.flush();
    }

    public <S extends Product> S saveAndFlush(S s) {
        return productRepository.saveAndFlush(s);
    }

    public void deleteInBatch(Iterable<Product> iterable) {
        productRepository.deleteInBatch(iterable);
    }

    public void deleteAllInBatch() {
        productRepository.deleteAllInBatch();
    }

    public Product getOne(Integer integer) {
        return productRepository.getOne(integer);
    }

    public <S extends Product> List<S> findAll(Example<S> example) {
        return productRepository.findAll(example);
    }

    public <S extends Product> List<S> findAll(Example<S> example, Sort sort) {
        return productRepository.findAll(example, sort);
    }

    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public <S extends Product> S save(S s) {
        return productRepository.save(s);
    }

    @Override
    public Optional<Product> findById(Integer integer) {
        return productRepository.findById(integer);
    }

    public boolean existsById(Integer integer) {
        return productRepository.existsById(integer);
    }

    public long count() {
        return productRepository.count();
    }

    @Override
    public void deleteById(Integer integer) {
        productRepository.deleteById(integer);
    }

    public void delete(Product product) {
        productRepository.delete(product);
    }

    public void deleteAll(Iterable<? extends Product> iterable) {
        productRepository.deleteAll(iterable);
    }

    public void deleteAll() {
        productRepository.deleteAll();
    }

    public <S extends Product> Optional<S> findOne(Example<S> example) {
        return productRepository.findOne(example);
    }

    public <S extends Product> Page<S> findAll(Example<S> example, Pageable pageable) {
        return productRepository.findAll(example, pageable);
    }

    public <S extends Product> long count(Example<S> example) {
        return productRepository.count(example);
    }

    public <S extends Product> boolean exists(Example<S> example) {
        return productRepository.exists(example);
    }
}

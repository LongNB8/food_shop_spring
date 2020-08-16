package com.example.food_shop_spring.Services;

import com.example.food_shop_spring.Models.PhotoPr;

import java.util.Optional;

public interface PhotoProService {
    <S extends PhotoPr> S save(S s);

    <S extends PhotoPr> Iterable<S> saveAll(Iterable<S> iterable);

    Optional<PhotoPr> findById(Integer integer);

    boolean existsById(Integer integer);

    Iterable<PhotoPr> findAll();

    Iterable<PhotoPr> findAllById(Iterable<Integer> iterable);

    long count();

    void deleteById(Integer integer);

    void delete(PhotoPr photoPr);

    void deleteAll(Iterable<? extends PhotoPr> iterable);

    void deleteAll();
}

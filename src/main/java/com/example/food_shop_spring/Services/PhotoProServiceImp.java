package com.example.food_shop_spring.Services;

import com.example.food_shop_spring.Models.PhotoPr;
import com.example.food_shop_spring.Repositories.PhotoPrRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Service
public class PhotoProServiceImp implements  PhotoProService {
    @Autowired
    private PhotoPrRepository photoPrRepository;

    @Override
    public <S extends PhotoPr> S save(S s) {
        return photoPrRepository.save(s);
    }

    @Override
    public <S extends PhotoPr> Iterable<S> saveAll(Iterable<S> iterable) {
        return photoPrRepository.saveAll(iterable);
    }

    @Override
    public Optional<PhotoPr> findById(Integer integer) {
        return photoPrRepository.findById(integer);
    }

    @Override
    public boolean existsById(Integer integer) {
        return photoPrRepository.existsById(integer);
    }

    @Override
    public Iterable<PhotoPr> findAll() {
        return photoPrRepository.findAll();
    }

    @Override
    public Iterable<PhotoPr> findAllById(Iterable<Integer> iterable) {
        return photoPrRepository.findAllById(iterable);
    }

    @Override
    public long count() {
        return photoPrRepository.count();
    }

    @Override
    public void deleteById(Integer integer) {
        photoPrRepository.deleteById(integer);
    }

    @Override
    public void delete(PhotoPr photoPr) {
        photoPrRepository.delete(photoPr);
    }

    @Override
    public void deleteAll(Iterable<? extends PhotoPr> iterable) {
        photoPrRepository.deleteAll(iterable);
    }

    @Override
    public void deleteAll() {
        photoPrRepository.deleteAll();
    }
}

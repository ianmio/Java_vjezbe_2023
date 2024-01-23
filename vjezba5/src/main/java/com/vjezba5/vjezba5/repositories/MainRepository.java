package com.vjezba5.vjezba5.repositories;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MainRepository<T> {
    public List<T> getAll();
    public T getById(Long x);
    public void add(T d);
    public void deleteById(Long x);
}
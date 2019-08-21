package com.fruitBake.service;

import com.fruitBake.domain.Fruits;

import java.util.List;

public interface FruitsService {
    public List<Fruits> findAll();

    public List<Fruits> findOne(String Fname);

    public void delete(String Fname);

    public void insert(Fruits fruits);

}

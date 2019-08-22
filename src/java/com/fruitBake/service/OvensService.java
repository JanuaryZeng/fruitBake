package com.fruitBake.service;

import com.fruitBake.domain.Fruits;
import com.fruitBake.domain.Ovens;

import java.util.List;

public interface OvensService {

    public List<Ovens> findAll();

    public void insert(Ovens ovens);

    public void delete(String id);

    public void update(Ovens ovens);

    public List<Ovens> findOne(String id);

}

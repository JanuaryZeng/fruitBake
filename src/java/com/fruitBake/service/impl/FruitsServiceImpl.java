package com.fruitBake.service.impl;

import com.fruitBake.dao.FruitsDao;
import com.fruitBake.domain.Fruits;
import com.fruitBake.service.FruitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("fruitsService")
public class FruitsServiceImpl implements FruitsService {

    @Autowired
    private FruitsDao fruitsDao;

    @Override
    public List<Fruits> findAll() {
        return fruitsDao.findAll();
    }

    @Override
    public List<Fruits> findOne(String Fname) {
        return fruitsDao.findOne(Fname);
    }

    @Override
    public void delete(String Fname) {
        fruitsDao.delete(Fname);
    }

    @Override
    public void insert(Fruits fruits) {
        fruitsDao.insert(fruits);
    }

    @Override
    public void update(Fruits fruits) {
        fruitsDao.update(fruits);
    }
}

package com.fruitBake.service.impl;

import com.fruitBake.dao.OvensDao;
import com.fruitBake.domain.Fruits;
import com.fruitBake.domain.Ovens;
import com.fruitBake.service.OvensService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ovensService")
public class OvensServiceImpl implements OvensService {

    @Autowired
    private OvensDao ovensDao;

    @Override
    public List<Ovens> findAll() {
        return ovensDao.findAll();
    }

    @Override
    public void insert(Ovens ovens){
        ovensDao.insert(ovens);
    }

    @Override
    public void delete(String id) {
        ovensDao.delete(id);
    }

    @Override
    public void update(Ovens ovens) {
        ovensDao.update(ovens);
    }

    @Override
    public List<Ovens> findOne(String id) {
        return ovensDao.findOne(id);
    }
}

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
    public void delete(String Oname) {
        ovensDao.delete(Oname);
    }

    @Override
    public void update(Ovens ovens) {
        ovensDao.update(ovens);
    }

    @Override
    public List<Ovens> findOne(String Oname) {
        return ovensDao.findOne(Oname);
    }

    @Override
    public void alterStatus(String Oname, String Ostatus) {
        ovensDao.alterStatus(Oname, Ostatus);
    }

    @Override
    public String findIP(String Oname) {
        return ovensDao.findIP(Oname);
    }
}

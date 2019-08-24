package com.fruitBake.service;

import com.fruitBake.domain.Fruits;
import com.fruitBake.domain.Ovens;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface OvensService {

    public List<Ovens> findAll();

    public void insert(Ovens ovens);

    public void delete(String Oname);

    public void update(Ovens ovens);

    public List<Ovens> findOne(String Oname);

    public void alterStatus(@Param("Oname") String Oname, @Param("Ostatus") String Ostatus);

    public String findIP(String Oname);


}

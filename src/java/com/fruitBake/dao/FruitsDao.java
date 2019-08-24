package com.fruitBake.dao;

import com.fruitBake.domain.Fruits;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FruitsDao {

    @Select("select * from fruits")
    public List<Fruits> findAll();

    @Select("select * from fruits where Fname = #{Fname}")
    public List<Fruits> findOne(String Fname);

    @Delete("delete from fruits where Fname = #{Fname}")
    public void delete(String Fname);

    @Insert("insert into fruits values(#{Fname},#{mean},#{Ficon})")
    public void insert(Fruits fruits);

    @Update("update fruits set mean = #{mean} Ficon = #{Ficon} where Fname = #{Fname}")
    public void update(Fruits fruits);

    @Select("select mean from fruits where Fname = #{Fname}")
    public String findMean(String Fname);
}

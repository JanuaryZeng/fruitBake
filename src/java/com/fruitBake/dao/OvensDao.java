package com.fruitBake.dao;

import com.fruitBake.domain.Fruits;
import com.fruitBake.domain.Ovens;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OvensDao {

    @Select("select * from ovens")
    public List<Ovens> findAll();

    @Insert("insert into ovens (Oname,Ostatus) values(#{Oname},#{Ostatus})")
    public void insert(Ovens ovens);

    @Delete("delete from ovens where id = #{id}")
    public void delete(String id);

    @Update("update ovens set Oname = #{Oname}, Ostatus = #{Ostatus} where id = #{id}")
    public void update(Ovens ovens);

    @Select("select * from ovens where id = #{id}")
    public List<Ovens> findOne(String id);
}

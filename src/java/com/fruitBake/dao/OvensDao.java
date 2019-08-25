package com.fruitBake.dao;

import com.fruitBake.domain.Fruits;
import com.fruitBake.domain.Ovens;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OvensDao {

    @Select("select * from ovens")
    public List<Ovens> findAll();

    @Insert("insert into ovens (Oname,Ostatus,IP) values(#{Oname},#{Ostatus},#{IP})")
    public void insert(Ovens ovens);

    @Delete("delete from ovens where Oname = #{Oname}")
    public void delete(String Oname);

    @Update("update ovens set Ostatus = #{Ostatus} , IP = #{IP} where Oname = #{Oname}")
    public void update(Ovens ovens);

    @Select("select * from ovens where Oname = #{Oname}")
    public List<Ovens> findOne(String Oname);

    @Update("update ovens set Ostatus = #{Ostatus} where Oname = #{Oname}")
    public void alterStatus(@Param("Oname") String Oname,@Param("Ostatus") String Ostatus);


    @Select("select IP from ovens where Oname = #{Oname}")
    public String findIP(String Oname);
}

package com.fruitBake.dao;

import com.fruitBake.domain.Users;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersDao {


    @Select("select * from Users")
    public List<Users> findAll();

    @Insert("insert into Users (Uname,Upassword,ovenCount) " +
            "values(#{Uname},#{Upassword},#{ovenCount})")
    public void save(Users users);

    @Delete("delete from users where Uname = #{Uname}")
    public void delete(String Uname);

    @Update("update users\n" +
            "set Upassword = #{Upassword}\n" +
            "where Uname = #{Uname}")
    public void updatePSW(@Param("Uname")String Uname,@Param("Upassword") String Upassword);

}

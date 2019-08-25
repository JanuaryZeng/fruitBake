package com.fruitBake.dao;

import com.fruitBake.domain.Users;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersDao {


    @Select("select * from Users")
    public List<Users> findAll();

    @Insert("insert into Users (Uname,Upassword,Uicon,Ucontext,phone) " +
            "values(#{Uname},#{Upassword},#{Uicon},#{Ucontext},#{phone})")
    public void save(Users users);

    @Delete("delete from users where Uname = #{Uname}")
    public void delete(String Uname);

    @Select("select * from Users where Uname = #{Uname} and Upassword = #{Upassword}")
    public Users login(@Param("Uname") String Uname,@Param("Upassword") String Upassword);

    @Insert("insert into Users (Uname,Upassword,Ucontext,phone) " +
            "values(#{Uname},#{Upassword},#{Ucontext},#{phone})")
    public void register(Users users);

    @Update("update Users set Upassword = #{Upassword} where Uname = #{Uname}")
    public void alterPassword(@Param("Uname") String Uname,@Param("Upassword") String Upassword);

    @Update("update Users set Upassword = #{Upassword}, Uicon = #{Uicon}, " +
            "Ucontext = #{Ucontext}, phone = #{phone} where Uname = #{Uname}")
    public void update(Users users);

    @Select("select * from Users where Uname = #{Uname}")
    public List<Users> findOne(String Uname);

    @Update("update Users set Ucontext = #{Ucontext}, phone = #{phone},Uicon = #{Uicon} where Uname = #{Uname}")
    public void userUpdate(@Param("Ucontext") String Ucontext,
                           @Param("phone") String phone,
                           @Param("Uicon") String Uicon,
                           @Param("Uname") String Uname);

}

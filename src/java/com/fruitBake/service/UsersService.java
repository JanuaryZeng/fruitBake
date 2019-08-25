package com.fruitBake.service;

import com.fruitBake.domain.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UsersService {

    public List<Users> findAll();

    public void save(Users users);

    public void delete(String Uname);

    public Users login(String Uname, String Upassword);

    public void register(Users users);

    public void alterPassword(@Param("Uname") String Uname,@Param("Upassword") String Upassword);

    public void update(Users users);

    public List<Users> findOne(String Uname);

    public void userUpdate(@Param("Ucontext") String Ucontext,
                           @Param("phone") String phone,
                           @Param("Uicon") String Uicon,
                           @Param("Uname") String Uname);
}

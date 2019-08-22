package com.fruitBake.service;

import com.fruitBake.domain.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UsersService {

    public List<Users> findAll();

    public void save(Users users);

    public void delete(String Uname);

    public Users login(String Uname);

}

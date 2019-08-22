package com.fruitBake.service.impl;

import com.fruitBake.dao.UsersDao;
import com.fruitBake.domain.Users;
import com.fruitBake.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("usersService")
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersDao usersDao;

    @Override
    public List<Users> findAll() {
        System.out.println("业务层：查询所有账户。。");
        return usersDao.findAll();
    }

    @Override
    public void save(Users users) {
        System.out.println("业务层：插入用户。。");
        usersDao.save(users);
    }

    @Override
    public void delete(String Uname) {
        usersDao.delete(Uname);
    }

    @Override
    public Users login(String Uname) {
        return usersDao.login(Uname);
    }

}

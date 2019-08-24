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
        return usersDao.findAll();
    }

    @Override
    public void save(Users users) {
        usersDao.save(users);
    }

    @Override
    public void delete(String Uname) {
        usersDao.delete(Uname);
    }

    @Override
    public Users login(String Uname, String Upassword) {
        return usersDao.login(Uname, Upassword);
    }

    @Override
    public void register(Users users) {
        usersDao.register(users);
    }

    @Override
    public void alterPassword(String Uname, String Upassword) {
        usersDao.alterPassword(Uname, Upassword);
    }

    @Override
    public void update(Users users) {
        usersDao.update(users);
    }

    @Override
    public List<Users> findOne(String Uname) {
        return usersDao.findOne(Uname);
    }


}

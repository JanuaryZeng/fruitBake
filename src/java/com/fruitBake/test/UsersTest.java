package com.fruitBake.test;

import com.fruitBake.dao.UsersDao;
import com.fruitBake.domain.Users;
import com.fruitBake.service.UsersService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration("src/resources")
@ContextConfiguration(locations={"classpath:applicationContext.xml","classpath:springmvc.xml"})
public class UsersTest {

    @Autowired
    private UsersDao usersDao;

    @Autowired
    private UsersService usersService;

    @Test
    public void spring(){
        //加载配置文件
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        //获取对象
        UsersService as = (UsersService) ac.getBean("usersService");
        //调用方法
        as.findAll();
    }

    @Test
    public void findAll(){
        System.out.println(usersService.findAll());
    }

    @Test
    public void login(){
        System.out.println(usersDao.login("jan","123"));
    }


    @Test
    public void update(){
        Users users = new Users();
        users.setUname("25");
        users.setUpassword("6196");
        usersService.update(users);
    }
    @Test
    public void alterOthers(){
        usersService.userUpdate("123","123","123","25");
    }
}

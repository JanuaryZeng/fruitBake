package com.fruitBake.controller;

import com.fruitBake.domain.Users;
import com.fruitBake.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @RequestMapping("/findAll")
    public String find(){
        System.out.println("控制层：查询");
        List<Users> list = usersService.findAll();

        for(Users users : list){
            System.out.println(users.toString());
        }

        System.out.println("控制层：查询成功");

        return "list";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }


}

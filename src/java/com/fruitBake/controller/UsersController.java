package com.fruitBake.controller;

import com.alibaba.fastjson.JSONObject;
import com.fruitBake.domain.Fruits;
import com.fruitBake.domain.Users;
import com.fruitBake.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @RequestMapping("/findAll")
    public String find(Map<String, Object> map){

        map.put("users",usersService.findAll());

        return "userTable";
    }

    @RequestMapping("/to_add")
    public String toAdd(Map<String,Object> map){
        map.put("userAdd",new Users());
        return "userAdd";
    }

    @RequestMapping("/add")
    public String add(Users users){
        usersService.save(users);
        return "redirect:findAll";
    }

    @RequestMapping("/delete")
    public String delete(String Uname) {
        usersService.delete(Uname);
        return "redirect:findAll";
    }


    @RequestMapping("/to_update")
    public String toUpdate(String Uname, Map<String,Object> map){
        map.put("toUpdate",usersService.findOne(Uname).get(0));
        return "userUpdate";
    }

    @RequestMapping("/update")
    public String toUpdate(Users users){
        System.out.println(users);
        usersService.update(users);
        return "redirect:findAll";
    }
    @RequestMapping("/findOne")
    public String findOne(String Uname, Map<String, Object> map){

        if(Uname.equals(""))
            map.put("users",usersService.findAll());
        else
            map.put("users",usersService.findOne(Uname));
        return "userTable";
    }

    @ResponseBody
    @RequestMapping("/login")
    public String login(String Uname, String Upassword){
        Users users = usersService.login(Uname, Upassword);
        if (users == null)
            return "";
        JSONObject json = new JSONObject();
        json.put("1",JSONObject.toJSON(users));

        //return json
        return json.toJSONString();
    }

    @ResponseBody
    @RequestMapping("/register")
    public String register(String uname, String upassword, String phone, String context){

        Users users = new Users();
        users.setPhone(phone);
        users.setUcontext(context);
        users.setUname(uname);
        users.setUpassword(upassword);

        usersService.register(users);

        JSONObject json = new JSONObject();
        json.put("1",users);
        //return json
        return json.toJSONString();

    }

    @ResponseBody
    @RequestMapping("/alterPassword")
    public String alterPassword(String id, String upassword){

        usersService.alterPassword(id, upassword);

        return "yes";

    }

    @ResponseBody
    @RequestMapping("/alterOters")
    public String alterOters(String Ucontext, String phone, String Uicon,String Uname){
        usersService.userUpdate(Ucontext,phone,Uicon,Uname);
        return "yes";
    }

}

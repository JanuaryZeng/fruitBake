package com.fruitBake.controller;

import com.alibaba.fastjson.JSONObject;
import com.fruitBake.domain.Fruits;
import com.fruitBake.service.FruitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/fruits")
public class FruitsController {

    @Autowired
    private FruitsService fruitsService;

    @RequestMapping("/findAll")
    public String findAll(Map<String, Object> map){

        map.put("fruits",fruitsService.findAll());
        return "fruitTable";
    }

    @RequestMapping("/findOne")
    public String findOne(String Fname, Map<String, Object> map){

        if(Fname.equals(""))
            map.put("fruits",fruitsService.findAll());
        else
            map.put("fruits",fruitsService.findOne(Fname));
        return "fruitTable";
    }

    @RequestMapping("/delete")
    public String delete(String Fname) {
        fruitsService.delete(Fname);
        return "redirect:findAll";
    }

    @RequestMapping("/to_add")
    public String toAdd(Map<String,Object> map){
        map.put("fruitAdd",new Fruits());
        return "fruitAdd";
    }

    @RequestMapping("/add")
    public String add(Fruits fruitAdd){
        fruitsService.insert(fruitAdd);
        return "redirect:findAll";
    }

    @RequestMapping(value = "to_update")
    public String toUpdate(String Fname, Map<String,Object> map){
        map.put("toUpdate",fruitsService.findOne(Fname).get(0));
        return "fruitUpdate";
    }

    @RequestMapping(value = "update")
    public String toUpdate(Fruits toUpdate){
        fruitsService.update(toUpdate);
        return "redirect:findAll";
    }

    @ResponseBody
    @RequestMapping("/SelectOne")
    public String SelectOne(String fname){
        Fruits fruits = fruitsService.findOne(fname).get(0);
        if (fruits == null)
            return "";
        JSONObject json = new JSONObject();
        json.put("SelectOne",JSONObject.toJSON(fruits));

        //return json
        return json.toJSONString();
    }

}

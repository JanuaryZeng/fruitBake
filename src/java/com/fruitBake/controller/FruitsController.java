package com.fruitBake.controller;

import com.fruitBake.domain.Fruits;
import com.fruitBake.service.FruitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

        map.put("fruit",fruitsService.findOne(Fname));

        return "redirect:findAll";
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


}

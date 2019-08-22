package com.fruitBake.controller;

import com.fruitBake.domain.Fruits;
import com.fruitBake.domain.Ovens;
import com.fruitBake.service.OvensService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/ovens")
public class OvensController {

    @Autowired
    private OvensService ovensService;

    @RequestMapping("/findAll")
    public String findAll(Map<String, Object> map){

        map.put("ovens",ovensService.findAll());
        return "ovenTable";
    }

    @RequestMapping("/to_add")
    public String toAdd(Map<String,Object> map){
        map.put("OvensAdd",new Ovens());
        return "ovenAdd";
    }

    @RequestMapping("/add")
    public String add(Ovens Ovens){
        ovensService.insert(Ovens);
        return "redirect:findAll";
    }

    @RequestMapping("/delete")
    public String delete(String id){
        ovensService.delete(id);
        return "redirect:findAll";
    }

    @RequestMapping(value = "to_update",params = "id")
    public String toUpdate(String id, Map<String,Object> map){
        map.put("toUpdate",ovensService.findOne(id).get(0));
        return "ovenUpdate";
    }

    @RequestMapping(value = "update")
    public String toUpdate(Ovens Ovens){
        ovensService.update(Ovens);
        return "redirect:findAll";
    }

    @RequestMapping("/findOne")
    public String findOne(String id, Map<String, Object> map){

        if(id.equals(""))
            map.put("ovens",ovensService.findAll());
        else
            map.put("ovens",ovensService.findOne(id));
        return "ovenTable";
    }

}

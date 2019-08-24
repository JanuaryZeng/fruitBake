package com.fruitBake.controller;

import com.alibaba.fastjson.JSONObject;
import com.fruitBake.domain.Fruits;
import com.fruitBake.domain.Ovens;
import com.fruitBake.service.OvensService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
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
    public String add(Ovens ovens){
        ovensService.insert(ovens);
        return "redirect:findAll";
    }

    @RequestMapping("/delete")
    public String delete(String Oname){
        ovensService.delete(Oname);
        return "redirect:findAll";
    }

    @RequestMapping("to_update")
    public String toUpdate(String Oname, Map<String,Object> map){
        map.put("toUpdate",ovensService.findOne(Oname).get(0));
        return "ovenUpdate";
    }

    @RequestMapping(value = "update")
    public String toUpdate(Ovens Ovens){
        ovensService.update(Ovens);
        return "redirect:findAll";
    }

    @RequestMapping("/findOne")
    public String findOne(String Oname, Map<String, Object> map){

        if(Oname.equals(""))
            map.put("ovens",ovensService.findAll());
        else
            map.put("ovens",ovensService.findOne(Oname));
        return "ovenTable";
    }

    @ResponseBody
    @RequestMapping("/alterStatus")
    public String alterStatus(String ovenname, String statue){
        ovensService.alterStatus(ovenname,statue);

        JSONObject json = new JSONObject();
        json.put("alterStatus","alterStatus");

        return json.toJSONString();
    }

    @ResponseBody
    @RequestMapping("/AndroidFindAll")
    public String AndroidFindAll(){
        List<Ovens> list = ovensService.findAll();
        JSONObject json = new JSONObject();
        int i = 1;

        for(Ovens ovens : list){
            json.put(String.valueOf(i),JSONObject.toJSON(ovens));
            i++;
        }


        return json.toJSONString();
    }
}

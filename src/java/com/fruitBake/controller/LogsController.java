package com.fruitBake.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fruitBake.service.LogsService;
import org.apache.ibatis.annotations.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("logs")
public class LogsController {

    @Autowired
    private LogsService logsService;

    @ResponseBody
    @RequestMapping("/findByNoteId")
    public String findByNoteId(String noteId){

        JSONObject json = new JSONObject();

        json.put("findByNoteId",logsService.findByNote(noteId));

        return json.toJSONString();
    }

}

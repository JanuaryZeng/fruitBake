package com.fruitBake.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fruitBake.domain.Fruits;
import com.fruitBake.domain.HardData;
import com.fruitBake.domain.Logs;
import com.fruitBake.domain.Notes;
import com.fruitBake.service.FruitsService;
import com.fruitBake.service.LogsService;
import com.fruitBake.service.NotesService;
import com.fruitBake.service.OvensService;
import com.sun.org.apache.xerces.internal.xs.datatypes.ObjectList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/hardware")
public class HardController {

    @Autowired
    private LogsService logsService;

    @Autowired
    private NotesService notesService;

    @Autowired
    private FruitsService fruitsService;

    @Autowired
    private OvensService ovensService;

    @ResponseBody
    @RequestMapping(value = "/put", produces = "application/json;charset=UTF-8")
    public void put(@RequestBody String str){
        JSONObject  jsonObject = JSONObject.parseObject(str);
        //json对象转Map
        Map<String,Object> map = (Map<String,Object>)jsonObject;

        Logs logs = new Logs();

        logs.setNoteId((Integer) map.get("noteId"));
        logs.setTemp(Float.parseFloat(map.get("temp").toString()));
        logs.setHumi(Float.parseFloat(map.get("humi").toString()));
        logs.setLtime(map.get("Ltime").toString());
        logs.setLev( map.get("Lev").toString());
        logsService.insert(logs);
    }

    @ResponseBody
    @RequestMapping(value = "/listener", produces = "application/json;charset=UTF-8")
    public String listener(){
        List<Notes> list = notesService.findByStatus();

        JSONObject json = new JSONObject();
        int i = 1;
        for(Notes notes : list){
            String MAC = ovensService.findIP(notes.getOname());
            String mean = fruitsService.findMean(notes.getFname());
            HardData hardData = new HardData(MAC, mean);

            hardData.setFlag("0");
            hardData.setEndTime(notes.getEndTime());
            hardData.setStartTime(notes.getStartTime());
            hardData.setNoteId(notes.getNoteId());

            json.put(String.valueOf(i),JSONObject.toJSON(hardData));
            i++;
        }

        List<Notes> list1 = notesService.findByStatus();
        for(Notes notes : list1){
            String MAC = ovensService.findIP(notes.getOname());
            String mean = fruitsService.findMean(notes.getFname());
            HardData hardData = new HardData(MAC, mean);

            hardData.setFlag("1");
            hardData.setEndTime(notes.getEndTime());
            hardData.setStartTime(notes.getStartTime());
            hardData.setNoteId(notes.getNoteId());

            json.put(String.valueOf(i),JSONObject.toJSON(hardData));
            i++;
        }
        notesService.updateStatus();
        return json.toJSONString();
    }

    @RequestMapping("/home")
    public String home(Map<String, Object> map){
        map.put("work",notesService.currentWork());
        map.put("notes",notesService.findAll());
        return "home";
    }

    @RequestMapping("/lineChart")
    public String lineChart(String noteId,Map<String,Object> map){
        map.put("noteId",noteId);
        return "LineChart";
    }

    @RequestMapping("/findOne")
    public String findOne(String NoteId, Map<String, Object> map){
        map.put("work",notesService.currentWork());

        if(NoteId.equals(""))
            map.put("notes",notesService.findAll());
        else{
            List<Notes> list = notesService.findOne(NoteId);

            List<Notes> list1 = notesService.findOneByOname(NoteId);

            for(Notes notes : list1){
                list.add(notes);
            }

            List<Notes> list2 = notesService.findOneByUname(NoteId);

            for(Notes notes : list2){
                list.add(notes);
            }

            map.put("notes",list);
        }

        return "home";
    }

}

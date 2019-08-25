package com.fruitBake.controller;

import com.alibaba.fastjson.JSONObject;
import com.fruitBake.domain.FruitCount;
import com.fruitBake.domain.Notes;
import com.fruitBake.service.NotesService;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/notes")
public class NotesController {

    @Autowired
    private NotesService notesService;


    @RequestMapping("/findAll")
    public String findAll(Map<String, Object> map){

        map.put("notes",notesService.findAll());
        return "noteTable";
    }

    @RequestMapping("/findOne")
    public String findOne(String NoteId, Map<String, Object> map){

        if(NoteId.equals(""))
            map.put("notes",notesService.findAll());
        else
            map.put("notes",notesService.findOne(NoteId));
        return "noteTable";
    }

    @RequestMapping("delete")
    public String delete(String NoteId){
        notesService.delete(NoteId);
        return "redirect:findAll";
    }

    @ResponseBody
    @RequestMapping("/insert")
    public String insert(String oname,String fname,
                         String startTime,String endTime,String Uname){
        Notes notes = new Notes();
        notes.setOname(oname);
        notes.setFname(fname);
        notes.setStartTime(startTime);
        notes.setEndTime(endTime);
        notes.setUname(Uname);

        notesService.insert(notes);

        JSONObject json = new JSONObject();
        json.put("insert","insert");

        //return json
        return json.toJSONString();

    }

    @ResponseBody
    @RequestMapping("/byOname")
    public String byOname(String oname){
        List<Notes> list = notesService.byOname(oname);

        JSONObject json = new JSONObject();

        int i = 1;
        for(Notes  notes: list){
            json.put(String.valueOf(i),notes);
            i++;
        }

        //return json
        return json.toJSONString();

    }

    @ResponseBody
    @RequestMapping("/byUname")
    public String byUname(String uname){
        List<Notes> list = notesService.byUname(uname);

        JSONObject json = new JSONObject();
        int i = 1;
        for (Notes notes : list){
            json.put(String.valueOf(i),notes);
            i++;
        }

        //return json
        return json.toJSONString();

    }

    @ResponseBody
    @RequestMapping("/alterEndTime")
    public String alterEndTime(String noteId, String endTime){

        notesService.alterEndTime(noteId, endTime);

        JSONObject json = new JSONObject();
        json.put("1","alterEndTime");

        //return json
        return json.toJSONString();

    }

    @ResponseBody
    @RequestMapping("/fruitCount")
    public String fruitCount(){
        List<FruitCount> list = notesService.fruitCount();
        JSONObject json = new JSONObject();
        json.put("count",list);


        return json.toJSONString();
    }

}

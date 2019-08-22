package com.fruitBake.controller;

import com.fruitBake.service.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

}

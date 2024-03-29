package com.fruitBake.test;

import com.fruitBake.service.NotesService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration("src/resources")
@ContextConfiguration(locations={"classpath:applicationContext.xml","classpath:springmvc.xml"})
public class NotesTest {

    @Autowired
    private NotesService notesService;

    @Test
    public void findOne(){
        System.out.println(notesService.findOne("4"));
    }

    @Test
    public void fruitCount(){
//        System.out.println(notesService.fruitCount());
        notesService.alterEndTime("58", "2019-08-27 17:14:49");
    }

    @Test
    public void currentWork(){
        System.out.println(notesService.currentWork());
    }

}

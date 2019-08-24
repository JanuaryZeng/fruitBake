package com.fruitBake.test;

import com.fruitBake.domain.Logs;
import com.fruitBake.service.LogsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration("src/resources")
@ContextConfiguration(locations={"classpath:applicationContext.xml","classpath:springmvc.xml"})
public class LogsTest {

    @Autowired
    private LogsService logsService;

    @Test
    public void insert(){
        Logs logs = new Logs();
        logs.setNoteId(1);
        logs.setTemp((float) 12.5);
        logs.setHumi((float) 13.6);
        logs.setLtime("213");
        logs.setLev("213");
        logsService.insert(logs);
    }
}

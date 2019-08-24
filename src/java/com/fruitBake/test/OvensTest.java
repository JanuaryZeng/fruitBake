package com.fruitBake.test;

import com.fruitBake.dao.OvensDao;
import com.fruitBake.domain.Ovens;
import com.fruitBake.service.OvensService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration("src/resources")
@ContextConfiguration(locations={"classpath:applicationContext.xml","classpath:springmvc.xml"})
public class OvensTest {

    @Autowired
    private OvensDao ovensDao;
    @Autowired
    private OvensService ovensService;

    @Test
    public void insert(){
        Ovens ovens = new Ovens();

        ovens.setOname("asdasd");
        ovens.setOstatus("1");

        ovensDao.insert(ovens);

    }

    @Test
    public void delete(){
        ovensService.delete("1");
    }

    @Test
    public void update(){
        Ovens ovens = new Ovens();

        ovens.setOname("asdasd");
        ovens.setOstatus("1");
        ovensService.update(ovens);
    }

    @Test
    public void findOne(){
        ovensService.findOne("美的01");
    }

}

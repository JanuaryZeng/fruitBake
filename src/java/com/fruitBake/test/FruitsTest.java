package com.fruitBake.test;
import com.fruitBake.dao.FruitsDao;
import com.fruitBake.domain.Fruits;
import com.fruitBake.service.FruitsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import java.util.List;




@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration("src/resources")
@ContextConfiguration(locations={"classpath:applicationContext.xml","classpath:springmvc.xml"})
public class FruitsTest {
    //Dao
    @Autowired
    private FruitsDao fruitsDao;

    @Test
    public void DaoFindAll(){
        List<Fruits> list = fruitsDao.findAll();
        for(Fruits fruits : list){
            System.out.println(fruits);
        }
    }

    @Test
    public void DaoDelete(){
        fruitsDao.delete("21qwe3");
    }

    @Test
    public void DaoInsetrt(){
        Fruits fruits = new Fruits();
        fruits.setFname("21qwe3");
        fruits.setMean("1564");
        fruits.setFicon("123");
        fruitsDao.insert(fruits);
    }

    //Service
    @Autowired
    private FruitsService fruitsService;

    @Test
    public void SerFindAll(){
        List<Fruits> list = fruitsService.findAll();
        for(Fruits fruits : list){
            System.out.println(fruits);
        }
    }

    @Test
    public void SerDelete(){
        fruitsService.delete("123");
    }

    @Test
    public void SerInsetrt(){
        Fruits fruits = new Fruits();
        fruits.setFname("21dawwe3");
        fruits.setMean("1564");
        fruitsService.insert(fruits);
    }

}

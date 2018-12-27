package com.example.demo;

import com.example.demo.entity.Ac01;
import com.example.demo.moredatasource.Ac01DAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MqSpingbootApplicationTests {
    @Autowired
   private Ac01DAO ac01DAO;


    @Test
    public void contextLoads() {
        //执行SQL,输出查到的数据
        Ac01 ac01=ac01DAO.selectAc01(3269305L);
        System.out.println(ac01DAO.getCount());

    }

}

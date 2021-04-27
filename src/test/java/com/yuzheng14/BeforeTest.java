package com.yuzheng14;

import org.junit.After;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeforeTest {
    protected ApplicationContext context=new ClassPathXmlApplicationContext("spring-context.xml");
    @After
    public void sleep(){
        try{
            Thread.sleep(10000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

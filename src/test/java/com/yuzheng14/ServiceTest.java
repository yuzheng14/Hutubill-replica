package com.yuzheng14;

import com.yuzheng14.service.ConfigService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServiceTest {
    ApplicationContext context=new ClassPathXmlApplicationContext("spring-context.xml");
    @Test
    public void configServiceTest(){
        context.getBean("configService",ConfigService.class);
    }
}

package com.yuzheng14.gui.panel;

import com.yuzheng14.util.GUIUtil;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpendPanelTest {
    @Test
    public void test(){
        ApplicationContext context= new ClassPathXmlApplicationContext("spring-context.xml");
        SpendPanel panel=context.getBean("spendPanel",SpendPanel.class);
        GUIUtil.showPanel(panel);
        try{
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

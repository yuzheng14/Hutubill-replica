package com.yuzheng14.gui.panel;

import com.yuzheng14.util.GUIUtil;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainPanelTest {
    @Test
    public void test(){
        ApplicationContext context=new ClassPathXmlApplicationContext("spring-context.xml");
        GUIUtil.showPanel(context.getBean("mainPanel", MainPanel.class),1);
        try{
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

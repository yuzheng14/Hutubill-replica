package com.yuzheng14.gui.panel;

import com.yuzheng14.util.GUIUtil;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RecordPanelTest {
    @Test
    public void test(){
        GUIUtil.showPanel(new ClassPathXmlApplicationContext("spring-context.xml").getBean("recordPanel",RecordPanel.class));
        try{
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

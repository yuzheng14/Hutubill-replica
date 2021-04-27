package com.yuzheng14.gui.frame;

import com.yuzheng14.BeforeTest;
import org.junit.Test;
import org.springframework.beans.factory.BeanCreationException;

public class FrameTest extends BeforeTest {
    @Test
    public void showMainFrame(){
        MainFrame frame= context.getBean("mainFrame",MainFrame.class);
        frame.setVisible(true);
    }
    @Test
    public void beanCreationExceptionTest(){
        throw new BeanCreationException("1");
    }

    @Test
    public void classpathTest(){
        System.getProperty("java.classpath");
    }
}

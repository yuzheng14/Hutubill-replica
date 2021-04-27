package com.yuzheng14.util;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Field;

public class CircleProgressBarTest {
    @Test
    public void minimumProgressTest(){
        CircleProgressBar c=new CircleProgressBar();
        try {
            Field minimumProgress=c.getClass().getDeclaredField("minimumProgress");
            minimumProgress.setAccessible(true);
            try {
                Assert.assertEquals(0,minimumProgress.get(c));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test(){
        JPanel panel=new JPanel();
        ApplicationContext context=new ClassPathXmlApplicationContext("spring-context.xml");
        CircleProgressBar circleProgressBar=context.getBean("circleProgressBar",CircleProgressBar.class);
        circleProgressBar.setBackgroundColor(ColorUtil.getBlue());
        circleProgressBar.setProgress(0);

        JButton button=new JButton("点击");

        panel.setLayout(new BorderLayout());
        panel.add(circleProgressBar,BorderLayout.CENTER);
        panel.add(button,BorderLayout.SOUTH);

        GUIUtil.showPanel(panel);

        button.addActionListener(e -> new SwingWorker(){
            @Override
            protected Object doInBackground() {
                for (int i = 0; i < 100; i++) {
                    circleProgressBar.setProgress(i+1);
                    circleProgressBar.setForegroundColor(ColorUtil.getByPercentage(i+1));
                    try{
                        Thread.sleep(100);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                return null;
            }
        }.execute());

        try {
            Thread.sleep(10000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

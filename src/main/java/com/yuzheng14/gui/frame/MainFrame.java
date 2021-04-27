package com.yuzheng14.gui.frame;

import com.yuzheng14.gui.panel.MainPanel;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.swing.*;

/**
 * @author yuzheng14
 */
@Component
public class MainFrame extends JFrame {
//    private final ApplicationContext context=new ClassPathXmlApplicationContext("spring-context.xml");

    @Resource
    private MainPanel mainPanel;
    public static void main(String[] args) {

    }
    @PostConstruct
    public void init(){
        this.setSize(500,600);
        this.setTitle("一本糊涂账");
        this.setContentPane(mainPanel);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

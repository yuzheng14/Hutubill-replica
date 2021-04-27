package com.yuzheng14.startup;

import com.sun.tools.javac.Main;
import com.yuzheng14.gui.frame.MainFrame;
import com.yuzheng14.gui.panel.MainPanel;
import com.yuzheng14.gui.panel.SpendPanel;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.swing.*;

/**
 * @author yuzheng14
 */
@Component
public class Bootstrap {

    public static void main(String[] args) throws Exception{

        SwingUtilities.invokeAndWait(()->{
            ApplicationContext context=new ClassPathXmlApplicationContext("spring-context.xml");
            Bootstrap bootstrap=context.getBean("bootstrap",Bootstrap.class);
            bootstrap.getMainFrame().setVisible(true);
            bootstrap.getMainPanel().getWorkingPanel().show(bootstrap.getSpendPanel());
        });
    }

    @Resource
    private MainFrame mainFrame;
    @Resource
    private MainPanel mainPanel;
    @Resource
    private SpendPanel spendPanel;

    public MainFrame getMainFrame() {
        return mainFrame;
    }

    public MainPanel getMainPanel() {
        return mainPanel;
    }

    public SpendPanel getSpendPanel() {
        return spendPanel;
    }
}
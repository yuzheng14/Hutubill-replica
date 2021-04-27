package com.yuzheng14.util;

import org.junit.Test;

import javax.swing.*;

public class CenterPanelTest {
    @Test
    public void test(){
        JFrame f=new JFrame();
        f.setSize(200,200);
        f.setLocationRelativeTo(null);
        CenterPanel centerPanel=new CenterPanel(0.85,true);
        f.setContentPane(centerPanel);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        JButton b=new JButton("abc");
        centerPanel.show(b);
    }
}

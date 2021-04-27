package com.yuzheng14.util;

import org.junit.Test;

import javax.swing.*;

public class GUIUtilTest {
    @Test
    public void test() {
        JPanel panel = new JPanel();
        panel.add(new JButton("按钮1"));
        panel.add(new JButton("按钮2"));
        GUIUtil.showPanel(panel);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

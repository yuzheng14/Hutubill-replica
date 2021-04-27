package com.yuzheng14.gui.listener;

import com.yuzheng14.gui.panel.MainPanel;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author yuzheng14
 */
@Component
public class ToolBarListener implements ActionListener {
    @Resource
    private MainPanel mainPanel;

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        mainPanel.showByButton(button);
    }
}

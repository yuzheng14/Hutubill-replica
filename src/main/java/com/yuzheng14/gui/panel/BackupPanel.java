package com.yuzheng14.gui.panel;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;

/**
 * @author yuzheng14
 */
@Component
public class BackupPanel extends JPanel {
    private final JButton buttonBackup=new JButton("备份");

    @PostConstruct
    public void init(){
        this.add(buttonBackup);
    }
}

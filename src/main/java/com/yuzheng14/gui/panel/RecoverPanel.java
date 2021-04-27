package com.yuzheng14.gui.panel;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;

/**
 * @author yuzheng14
 */
@Component
public class RecoverPanel extends JPanel {
    private final JButton buttonRecover=new JButton("恢复");

    @PostConstruct
    public void init(){
        this.add(buttonRecover);
    }
}

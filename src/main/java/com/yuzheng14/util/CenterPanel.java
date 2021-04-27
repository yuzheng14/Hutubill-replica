package com.yuzheng14.util;

import com.yuzheng14.gui.panel.WorkingPanel;

import javax.swing.*;
import java.awt.*;


public class CenterPanel extends JPanel {
    //拉伸比例
    private double rate;
    //显示的组件
    private JComponent component;
    //是否拉伸
    private Boolean stretch;

    public CenterPanel(double rate, boolean stretch) {
        this.setLayout(null);
        this.rate = rate;
        this.stretch = stretch;
    }

    public CenterPanel(double rate) {
        this(rate, true);
    }

    @Override
    public void repaint() {
        if (null != component) {
            Dimension containerSize = this.getSize();
            Dimension componentSize = component.getPreferredSize();

            if (stretch) {
                component.setSize((int) (containerSize.width * rate), (int) (containerSize.height * rate));
            } else {
                component.setSize(componentSize);
            }
            component.setLocation(containerSize.width / 2 - component.getSize().width / 2, containerSize.height / 2 - component.getSize().height / 2);
        }
        super.repaint();
    }

    public void show(JComponent p) {
        this.component = p;
        Component[] components = getComponents();
        for (Component c : components) {
            remove(c);
        }
        add(p);

        if (p instanceof WorkingPanel){
            ((WorkingPanel)p).updateData();
            ((WorkingPanel)p).addListener();
        }
        this.updateUI();
    }
}

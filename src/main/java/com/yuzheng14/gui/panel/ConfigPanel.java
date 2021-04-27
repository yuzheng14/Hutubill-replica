package com.yuzheng14.gui.panel;

import com.yuzheng14.gui.listener.ConfigListener;
import com.yuzheng14.service.ConfigService;
import com.yuzheng14.util.ColorUtil;
import com.yuzheng14.util.GUIUtil;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.swing.*;
import java.awt.*;

/**
 * @author yuzheng14
 */
@Component
public class ConfigPanel extends WorkingPanel {
    private final JLabel labelBudget = new JLabel("本月预算（￥）");
    private final JTextField textFieldBudget = new JTextField("0");

    private final JLabel labelMySQL = new JLabel("MySQL安装目录");
    private final JTextField textFieldMySQL = new JTextField("");

    private final JButton buttonSubmit = new JButton("更新");

    @Resource
    private ConfigListener configListener;
    @Resource
    private ConfigService configService;

    @PostConstruct
    public void init() {
        GUIUtil.setColor(ColorUtil.getGray(), labelBudget, labelMySQL);
        GUIUtil.setColor(ColorUtil.getBlue(), buttonSubmit);

        JPanel panelInput = new JPanel();
        JPanel panelSubmit = new JPanel();

        int gap = 40;

        panelInput.setLayout(new GridLayout(4, 1, gap, gap));
        panelInput.add(labelBudget);
        panelInput.add(textFieldBudget);
        panelInput.add(labelMySQL);
        panelInput.add(textFieldMySQL);

        panelSubmit.add(buttonSubmit);

        this.setLayout(new BorderLayout());
        this.add(panelInput, BorderLayout.NORTH);
        this.add(panelSubmit, BorderLayout.CENTER);
    }

    public JTextField getTextFieldBudget() {
        return textFieldBudget;
    }

    public JTextField getTextFieldMySQL() {
        return textFieldMySQL;
    }

    @Override
    public void updateData() {
        String budget=configService.get(ConfigService.getBudget());
        String mysqlPath=configService.get(ConfigService.getMysqlPath());
        textFieldBudget.setText(budget);
        textFieldMySQL.setText(mysqlPath);
        textFieldBudget.grabFocus();
    }

    @Override
    public void addListener() {
        buttonSubmit.addActionListener(configListener);
    }
}

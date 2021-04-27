package com.yuzheng14.gui.listener;

import com.yuzheng14.gui.panel.ConfigPanel;
import com.yuzheng14.service.ConfigService;
import com.yuzheng14.util.GUIUtil;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

@Component
public class ConfigListener implements ActionListener {
    @Resource
    private ConfigPanel configPanel;
    @Resource
    private ConfigService configService;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!GUIUtil.checkNumber(configPanel.getTextFieldBudget(),"本月预算")){
            return;
        }
        String mysqlPath= configPanel.getTextFieldMySQL().getText();
        if (0!=mysqlPath.length()){
            File commandFile=new File(mysqlPath,"bin/mysql.exe");
            if (!commandFile.exists()){
                JOptionPane.showMessageDialog(configPanel,"MySQL路径不正确");
                configPanel.getTextFieldMySQL().grabFocus();
                return;
            }
        }
        configService.update(ConfigService.getBudget(),configPanel.getTextFieldBudget().getText());
        configService.update(ConfigService.getMysqlPath(),mysqlPath);
        JOptionPane.showMessageDialog(configPanel,"设置修改成功");
        configPanel.updateData();
    }
}

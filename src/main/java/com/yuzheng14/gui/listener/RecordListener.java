package com.yuzheng14.gui.listener;

import com.yuzheng14.entity.Category;
import com.yuzheng14.gui.panel.CategoryPanel;
import com.yuzheng14.gui.panel.MainPanel;
import com.yuzheng14.gui.panel.RecordPanel;
import com.yuzheng14.gui.panel.SpendPanel;
import com.yuzheng14.service.RecordService;
import com.yuzheng14.util.GUIUtil;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * @author yuzheng14
 */
@Component
public class RecordListener implements ActionListener {
    @Resource
    private RecordPanel recordPanel;
    @Resource
    private MainPanel mainPanel;
    @Resource
    private RecordService recordService;
    @Resource
    private CategoryPanel categoryPanel;
    @Resource
    private SpendPanel spendPanel;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (0==recordPanel.getCategoryComboBoxModel().getCategories().size()){
            JOptionPane.showMessageDialog(recordPanel,"暂无消费分类，无法添加，请先增加消费分类");
            mainPanel.getWorkingPanel().show(categoryPanel);
            return;
        }
        if (!GUIUtil.checkZero(recordPanel.getTextFieldSpend(),"花费金额")){
            return;
        }
        int spend=Integer.parseInt(recordPanel.getTextFieldSpend().getText());
        Category category=recordPanel.getSelectedCategory();
        String comment=recordPanel.getTextFieldComment().getText();
        Date date=recordPanel.getDatePicker().getDate();
        recordService.add(spend,category,comment,date);
        JOptionPane.showMessageDialog(recordPanel,"添加成功");
        recordPanel.updateData();

        mainPanel.getWorkingPanel().show(spendPanel);
    }
}

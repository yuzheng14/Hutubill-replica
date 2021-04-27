package com.yuzheng14.gui.listener;

import com.yuzheng14.entity.Category;
import com.yuzheng14.gui.panel.CategoryPanel;
import com.yuzheng14.service.CategoryService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * @author yuzheng14
 */
@Component
public class CategoryListener implements ActionListener {
    @Resource
    private CategoryPanel categoryPanel;
    @Resource
    private CategoryService categoryService;

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button=(JButton) e.getSource();
        if (button==categoryPanel.getButtonAdd()){
            actionAdd();
        }else if (button==categoryPanel.getButtonEdit()){
            actionEdit();
        }else if (button==categoryPanel.getButtonDelete()){
            actionDelete();
        }
        categoryPanel.updateData();
    }

    private void actionAdd(){
        String name=JOptionPane.showInputDialog(null);
        if (0==name.length()){
            JOptionPane.showMessageDialog(categoryPanel,"分类名称不能为空");
            return;
        }
        categoryService.add(name);
    }

    private void actionEdit(){
        Category category=categoryPanel.getSelectedCategory();
        int id=category.getId();
        String name=JOptionPane.showInputDialog("修改分类名称",category.getName());
        if (0==name.length()){
            JOptionPane.showMessageDialog(categoryPanel,"分类名称不能为空");
            return;
        }
        categoryService.update(id,name);
    }

    private void actionDelete(){
        Category category=categoryPanel.getSelectedCategory();
        if (0!=category.getRecordNumber()){
            JOptionPane.showMessageDialog(categoryPanel,"本分类下有消费记录存在，不能删除");
            return;
        }
        if (JOptionPane.OK_OPTION!=JOptionPane.showConfirmDialog(categoryPanel,"确认要删除？")){
            return;
        }
        categoryService.delete(category.getId());
    }
}

package com.yuzheng14.gui.panel;

import com.yuzheng14.entity.Category;
import com.yuzheng14.gui.listener.CategoryListener;
import com.yuzheng14.gui.model.CategoryTableModel;
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
public class CategoryPanel extends WorkingPanel {
    private final JButton buttonAdd=new JButton("新增");
    private final JButton buttonEdit=new JButton("编辑");
    private final JButton buttonDelete=new JButton("删除");

    private final String[] columnNames=new String[]{"分类名称","消费次数"};

    @Resource
    private CategoryTableModel categoryTableModel;
    @Resource
    private CategoryListener categoryListener;

    private JTable table;

    @PostConstruct
    public void init(){
        table=new JTable(categoryTableModel);
        GUIUtil.setColor(ColorUtil.getBlue(),buttonAdd,buttonEdit,buttonDelete);

        JScrollPane scrollPane=new JScrollPane(table);
        JPanel panelSubmit=new JPanel();

        panelSubmit.add(buttonAdd);
        panelSubmit.add(buttonDelete);
        panelSubmit.add(buttonEdit);

        this.setLayout(new BorderLayout());
        this.add(scrollPane,BorderLayout.CENTER);
        this.add(panelSubmit,BorderLayout.SOUTH);
    }

    public Category getSelectedCategory(){
        return categoryTableModel.getCategory(table.getSelectedRow());
    }

    @Override
    public void updateData(){
        categoryTableModel.updateCategories();
        table.updateUI();
        table.getSelectionModel().setSelectionInterval(0,0);

        if (categoryTableModel.categoriesIsNull()){
            buttonEdit.setEnabled(false);
            buttonDelete.setEnabled(false);
        }else {
            buttonDelete.setEnabled(true);
            buttonEdit.setEnabled(true);
        }
    }

    @Override
    public void addListener(){
        buttonEdit.addActionListener(categoryListener);
        buttonAdd.addActionListener(categoryListener);
        buttonDelete.addActionListener(categoryListener);
    }

    public JButton getButtonAdd() {
        return buttonAdd;
    }

    public JButton getButtonDelete() {
        return buttonDelete;
    }

    public JButton getButtonEdit() {
        return buttonEdit;
    }
}

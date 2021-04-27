package com.yuzheng14.gui.panel;

import com.yuzheng14.entity.Category;
import com.yuzheng14.gui.listener.RecordListener;
import com.yuzheng14.gui.model.CategoryComboBoxModel;
import com.yuzheng14.util.ColorUtil;
import com.yuzheng14.util.GUIUtil;
import org.jdesktop.swingx.JXDatePicker;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.swing.*;
import java.awt.*;
import java.util.Date;

/**
 * @author yuzheng14
 */
@Component
public class RecordPanel extends WorkingPanel {

    JLabel spendLabel=new JLabel("花费（￥）");
    JLabel categoryLabel=new JLabel("分类");
    JLabel commentLabel=new JLabel("备注");
    JLabel dateLabel=new JLabel("日期");

    private final JTextField textFieldSpend=new JTextField("0");

    @Resource
    private CategoryComboBoxModel categoryComboBoxModel;
    @Resource
    private RecordListener recordListener;

    private JComboBox<Category> comboBoxCategory;
    private final JTextField textFieldComment=new JTextField();
    private final JXDatePicker datePicker=new JXDatePicker(new Date());

    JButton buttonSubmit=new JButton("记一笔");

    @PostConstruct
    public void init(){
        GUIUtil.setColor(ColorUtil.getGray(),spendLabel,categoryLabel,commentLabel,dateLabel);
        GUIUtil.setColor(ColorUtil.getBlue(),buttonSubmit);

        comboBoxCategory=new JComboBox<>(categoryComboBoxModel);

        JPanel panelInput=new JPanel();
        JPanel panelSubmit=new JPanel();

        int gap=40;
        panelInput.setLayout(new GridLayout(4,2,gap,gap));

        panelInput.add(spendLabel);
        panelInput.add(textFieldSpend);
        panelInput.add(categoryLabel);
        panelInput.add(comboBoxCategory);
        panelInput.add(commentLabel);
        panelInput.add(textFieldComment);
        panelInput.add(dateLabel);
        panelInput.add(datePicker);

        panelSubmit.add(buttonSubmit);

        this.setLayout(new BorderLayout());
        this.add(panelInput,BorderLayout.NORTH);
        this.add(panelSubmit,BorderLayout.CENTER);
    }

    public Category getSelectedCategory(){
        return (Category) categoryComboBoxModel.getSelectedItem();
    }


    public CategoryComboBoxModel getCategoryComboBoxModel() {
        return categoryComboBoxModel;
    }

    public JTextField getTextFieldSpend() {
        return textFieldSpend;
    }

    public JTextField getTextFieldComment() {
        return textFieldComment;
    }

    public JButton getButtonSubmit() {
        return buttonSubmit;
    }

    public JXDatePicker getDatePicker() {
        return datePicker;
    }

    @Override
    public void updateData() {
        categoryComboBoxModel.updateCategories();
        comboBoxCategory.updateUI();
        resetInput();
        textFieldSpend.grabFocus();
    }

    public void resetInput(){
        textFieldSpend.setText("0");
        textFieldComment.setText("");
        if (0!=categoryComboBoxModel.getCategories().size()){
            comboBoxCategory.setSelectedItem(0);
        }
        datePicker.setDate(new Date());
    }

    @Override
    public void addListener() {
        buttonSubmit.addActionListener(recordListener);
    }
}


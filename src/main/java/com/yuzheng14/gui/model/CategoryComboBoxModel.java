package com.yuzheng14.gui.model;

import com.yuzheng14.entity.Category;
import com.yuzheng14.service.CategoryService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yuzheng14
 */
@Component
public class CategoryComboBoxModel implements ComboBoxModel<Category> {
    @Resource
    private CategoryService categoryService;

    private List<Category> categories;
    private Category category;

    @PostConstruct
    public void init(){
        categories=categoryService.list();
        if (!categories.isEmpty()){
            category=categories.get(0);
        }
    }

    @Override
    public void setSelectedItem(Object anItem) {
        category=(Category) anItem;
    }

    @Override
    public Object getSelectedItem() {
        if (!categories.isEmpty()){
            return category;
        }else {
            return null;
        }
    }

    @Override
    public int getSize() {
        return categories.size();
    }

    @Override
    public Category getElementAt(int index) {
        return categories.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {

    }

    @Override
    public void removeListDataListener(ListDataListener l) {

    }

    public List<Category> getCategories() {
        return categories;
    }

    public void updateCategories(){
        categories=categoryService.list();
    }
}

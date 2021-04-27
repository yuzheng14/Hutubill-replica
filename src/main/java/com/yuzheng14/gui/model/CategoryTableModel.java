package com.yuzheng14.gui.model;

import com.yuzheng14.entity.Category;
import com.yuzheng14.service.CategoryService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yuzheng14
 */
@Component
public class CategoryTableModel implements TableModel {
    private final String[] columnNames=new String[]{"分类名称","消费次数"};
    @Resource
    private CategoryService categoryService;

    private List<Category> categories;
    @PostConstruct
    public void init(){
        categories=categoryService.list();
    }

    @Override
    public int getRowCount() {
        return categories.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return Category.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Category category=categories.get(rowIndex);
        if (0==columnIndex){
            return category.getName();
        }else if (1==columnIndex){
            return category.getRecordNumber();
        }else {
            return null;
        }
    }

    public Category getCategory(int rowIndex){
        return categories.get(rowIndex);
    }

    public void updateCategories(){
        categories=categoryService.list();
    }

    public boolean categoriesIsNull(){
        return categories.size()==0;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }
}

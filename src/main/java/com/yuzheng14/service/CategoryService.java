package com.yuzheng14.service;

import com.yuzheng14.dao.CategoryDAO;
import com.yuzheng14.entity.Category;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yuzheng14
 */
@Component
public class CategoryService {
    @Resource
    private CategoryDAO categoryDAO;
    @Resource
    private Category category;

    public List<Category> list(){
        List<Category> categories=categoryDAO.list();
        categories.sort((category1, category2) -> category2.getRecordNumber() - category1.getRecordNumber());
        return categories;
    }

    public void add(String name){
        category =new Category();
        category.setName(name);
        categoryDAO.add(category);
    }

    public void update(int id,String name){
        category=new Category();
        category.setName(name);
        category.setId(id);
        categoryDAO.update(category);
    }

    public void delete(int id){
        categoryDAO.delete(id);
    }
}

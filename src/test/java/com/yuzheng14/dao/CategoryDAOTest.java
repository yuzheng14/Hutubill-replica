package com.yuzheng14.dao;

import com.yuzheng14.entity.Category;
import org.junit.Test;

public class CategoryDAOTest {
    Category category=new Category();
    CategoryDAO categoryDAO=new CategoryDAO();
    @Test
    public void addTest(){
        category.setName("餐饮");
        categoryDAO.add(category);
        System.out.println(category);
        System.out.println(categoryDAO.list());
    }
    @Test
    public void updateTest(){
        category.setId(1);
        category.setName("交通");
        categoryDAO.update(category);
        System.out.println(categoryDAO.list());
    }
    @Test
    public void getTotalTest(){
        System.out.println(categoryDAO.getTotal());
    }
    @Test
    public void getTest(){
        System.out.println(categoryDAO.get(1));
    }
    @Test
    public void deleteTest(){
        categoryDAO.delete(1);
        System.out.println(categoryDAO.list());
    }
}

package com.yuzheng14.dao;

import com.yuzheng14.entity.Config;
import org.junit.Test;

public class ConfigDAOTest {
    Config config=new Config();
    ConfigDAO configDAO=new ConfigDAO();
    @Test
    public void addTest(){
        config.setKey("1");
        config.setValue("1");
        configDAO.add(config);
        System.out.println(configDAO.list());
    }
    @Test
    public void updateTest(){
        config.setId(1);
        config.setKey("2");
        config.setValue("2");
        configDAO.update(config);
        System.out.println(configDAO.list());
    }
    @Test
    public void getTest(){
        config=configDAO.get(1);
        System.out.println(config);
    }
    @Test
    public void getByKeyTest(){
        config=configDAO.getByKey("1");
        System.out.println(config);
    }
    @Test
    public void getTotalTest(){
        System.out.println(configDAO.getTotal());
    }
    @Test
    public void deleteTest(){
        configDAO.delete(1);
        System.out.println(configDAO.list());
    }
}

package com.yuzheng14.service;

import com.yuzheng14.dao.RecordDAO;
import com.yuzheng14.entity.Category;
import com.yuzheng14.entity.Record;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author yuzheng14
 */
@Component
public class RecordService {
    @Resource
    private RecordDAO recordDAO;

    public void add(int spend, Category category, String comment, Date date){
        Record record=new Record();
        record.setSpend(spend);
        record.setCategoryId(category.getId());
        record.setComment(comment);
        record.setDate(date);
        recordDAO.add(record);
    }

    public void add(int spend, int categoryId, String comment, Date date){
        Record record=new Record();
        record.setSpend(spend);
        record.setCategoryId(categoryId);
        record.setComment(comment);
        record.setDate(date);
        recordDAO.add(record);
    }
}

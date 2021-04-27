package com.yuzheng14.entity;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author yuzheng14
 */
@Component
public class Record {
    private int spend;
    private int id;
    private int categoryId;
    private String comment;
    private Date date;

    public void setId(int id) {
        this.id = id;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setSpend(int spend) {
        this.spend = spend;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getComment() {
        return comment;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public int getSpend() {
        return spend;
    }
}

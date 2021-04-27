package com.yuzheng14.entity;

import org.springframework.stereotype.Component;

/**
 * @author yuzheng14
 */
@Component
public class Category {
    private int id;
    private String name;
    private  int recordNumber;

    public int getId() {
        return id;
    }

    public int getRecordNumber() {
        return recordNumber;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRecordNumber(int recordNumber) {
        this.recordNumber = recordNumber;
    }

    @Override
    public String toString() {
        return name;
    }


}

package com.yuzheng14.util;

import com.yuzheng14.service.ReportService;
import org.junit.Test;

import javax.annotation.Resource;
import javax.swing.*;
import java.awt.*;

public class ChartUtilTest {
    @Resource
    private ReportService reportService;
    @Test
    public void test(){
        JPanel panel=new JPanel();
        JLabel label=new JLabel();
        Image image=ChartUtil.getImage(reportService.listThisMOnthRecords(), 400,300);
        Icon icon=new ImageIcon(image);
        label.setIcon(icon);
        panel.add(label);
        GUIUtil.showPanel(panel);
        try{
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

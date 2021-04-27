package com.yuzheng14.gui.panel;

import com.yuzheng14.entity.Record;
import com.yuzheng14.service.ReportService;
import com.yuzheng14.util.ChartUtil;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * @author yuzheng14
 */
@Component
public class ReportPanel extends WorkingPanel {

    private final JLabel label = new JLabel();

    @Resource
    private ReportService reportService;

    @PostConstruct
    public void init() {
        this.setLayout(new BorderLayout());

        List<Record> records = reportService.listThisMOnthRecords();
        Image image = ChartUtil.getImage(records, 400, 300);
        ImageIcon icon = new ImageIcon(image);

        label.setIcon(icon);

        this.add(label);
        addListener();
    }

    @Override
    public void updateData() {
        List<Record> records = reportService.listThisMOnthRecords();
        Image image = ChartUtil.getImage(records, 400, 300);
        ImageIcon icon = new ImageIcon(image);
        label.setIcon(icon);
    }

    @Override
    public void addListener() {

    }
}

package com.yuzheng14.gui.panel;

import com.yuzheng14.gui.page.SpendPage;
import com.yuzheng14.service.SpendService;
import com.yuzheng14.util.CircleProgressBar;
import com.yuzheng14.util.ColorUtil;
import com.yuzheng14.util.GUIUtil;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.swing.*;
import java.awt.*;

/**
 * @author yuzheng14
 */
@Component
public class SpendPanel extends WorkingPanel {
    JLabel monthSpendLabel = new JLabel("本月消费");
    JLabel todaySpendLabel = new JLabel("今日消费");
    JLabel averageSpendPerDayLabel = new JLabel("日均消费");
    JLabel monthLeftLabel = new JLabel("本月剩余");
    JLabel dayAverageAvailableLabel = new JLabel("日均可用");
    JLabel monthLeftDayLabel = new JLabel("距离月末");

    JLabel monthSpendView = new JLabel("￥2300");
    JLabel todaySpendView = new JLabel("￥25");
    JLabel averageSpendPerDayView = new JLabel("￥120");
    JLabel monthAvailableView = new JLabel("￥2084");
    JLabel dayAverageAvailableView = new JLabel("￥289");
    JLabel monthLeftDayView = new JLabel("15天");

    @Resource
    private SpendService spendService;
    @Resource
    CircleProgressBar circleProgressBar;

    @PostConstruct
    public void init() {
        this.setLayout(new BorderLayout());
        circleProgressBar.setBackgroundColor(ColorUtil.getBlue());

        GUIUtil.setColor(ColorUtil.getGray(), monthSpendLabel, todaySpendLabel, averageSpendPerDayLabel, monthLeftLabel, dayAverageAvailableLabel, monthLeftDayLabel, averageSpendPerDayView, monthAvailableView, dayAverageAvailableView, monthLeftDayView);
        GUIUtil.setColor(ColorUtil.getBlue(), monthSpendView, todaySpendView);

        monthSpendView.setFont(new Font("微软雅黑", Font.BOLD, 23));
        todaySpendView.setFont(new Font("微软雅黑", Font.BOLD, 23));

        this.add(center(), BorderLayout.CENTER);
        this.add(south(), BorderLayout.SOUTH);
    }

    private JPanel center() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(west(), BorderLayout.WEST);
        panel.add(center2(), BorderLayout.CENTER);
        return panel;
    }

    private java.awt.Component center2() {
        return circleProgressBar;
    }

    private java.awt.Component west() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));
        panel.add(monthSpendLabel);
        panel.add(monthSpendView);
        panel.add(todaySpendLabel);
        panel.add(todaySpendView);
        return panel;
    }

    private JPanel south() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 4));
        panel.add(averageSpendPerDayLabel);
        panel.add(monthLeftLabel);
        panel.add(dayAverageAvailableLabel);
        panel.add(monthLeftDayLabel);

        panel.add(averageSpendPerDayView);
        panel.add(monthAvailableView);
        panel.add(dayAverageAvailableView);
        panel.add(monthLeftDayView);

        return panel;
    }

    @Override
    public void updateData() {
        SpendPage spendPage=spendService.getSpendPage();

        monthSpendView.setText(spendPage.getMonthSpend());
        todaySpendView.setText(spendPage.getTodaySpend());
        averageSpendPerDayView.setText(spendPage.getAverageSpendPerDay());
        monthAvailableView.setText(spendPage.getMonthAvailable());
        dayAverageAvailableView.setText(spendPage.getDayAverageAvailable());
        monthLeftDayView.setText(spendPage.getMonthLeftDay());

        circleProgressBar.setProgress(spendPage.getUsagePercentage());

        if (spendPage.isOverSpend()){
            monthAvailableView.setForeground(ColorUtil.getWarning());
            monthSpendView.setForeground(ColorUtil.getWarning());
            todaySpendView.setForeground(ColorUtil.getWarning());
        }else {
            monthAvailableView.setForeground(ColorUtil.getGray());
            monthSpendView.setForeground(ColorUtil.getBlue());
            todaySpendView.setForeground(ColorUtil.getBlue());
        }
        circleProgressBar.setForegroundColor(ColorUtil.getByPercentage(spendPage.getUsagePercentage()));
        addListener();
    }

    @Override
    public void addListener() {

    }
}

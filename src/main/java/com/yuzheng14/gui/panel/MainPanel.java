package com.yuzheng14.gui.panel;

import com.yuzheng14.gui.listener.ToolBarListener;
import com.yuzheng14.util.CenterPanel;
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
public class MainPanel extends JPanel {
    private final JToolBar toolBar = new JToolBar();
    private final JButton spendButton = new JButton();
    private final JButton recordButton = new JButton();
    private final JButton categoryButton = new JButton();
    private final JButton reportButton = new JButton();
    private final JButton configButton = new JButton();
    private final JButton backupButton = new JButton();
    private final JButton recoverButton = new JButton();
    private final CenterPanel workingPanel = new CenterPanel(0.8);
    @Resource
    private ReportPanel reportPanel;
    @Resource
    private SpendPanel spendPanel;
    @Resource
    private RecordPanel recordPanel;
    @Resource
    private CategoryPanel categoryPanel;
    @Resource
    private ConfigPanel configPanel;
    @Resource
    private BackupPanel backupPanel;
    @Resource
    private RecoverPanel recoverPanel;
    @Resource
    private ToolBarListener toolBarListener;

    @PostConstruct
    public void init() {
        GUIUtil.setImageIcon(spendButton, "home.png", "消费一览");
        GUIUtil.setImageIcon(recordButton, "record.png", "记一笔");
        GUIUtil.setImageIcon(categoryButton, "category2.png", "消费分类");
        GUIUtil.setImageIcon(reportButton, "report.png", "月消费报表");
        GUIUtil.setImageIcon(configButton, "config.png", "设置");
        GUIUtil.setImageIcon(backupButton, "backup.png", "备份");
        GUIUtil.setImageIcon(recoverButton, "restore.png", "恢复");

        toolBar.add(spendButton);
        toolBar.add(recordButton);
        toolBar.add(categoryButton);
        toolBar.add(reportButton);
        toolBar.add(configButton);
        toolBar.add(backupButton);
        toolBar.add(recoverButton);
        toolBar.setFloatable(false);

        setLayout(new BorderLayout());
        add(toolBar, BorderLayout.NORTH);
        add(workingPanel, BorderLayout.CENTER);

        spendButton.addActionListener(toolBarListener);
        recordButton.addActionListener(toolBarListener);
        categoryButton.addActionListener(toolBarListener);
        reportButton.addActionListener(toolBarListener);
        configButton.addActionListener(toolBarListener);
        backupButton.addActionListener(toolBarListener);
        recoverButton.addActionListener(toolBarListener);
    }

    public CenterPanel getWorkingPanel() {
        return workingPanel;
    }

    /**
     * 通过传入的button实例判断展示哪个panel
     *
     * @param button
     */
    public void showByButton(JButton button) {
        if (button == reportButton) {
            workingPanel.show(reportPanel);
        } else if (button == categoryButton) {
            workingPanel.show(categoryPanel);
        } else if (button == spendButton) {
            workingPanel.show(spendPanel);
        } else if (button == recordButton) {
            workingPanel.show(recordPanel);
        } else if (button == configButton) {
            workingPanel.show(configPanel);
        } else if (button == backupButton) {
            workingPanel.show(backupPanel);
        } else if (button == recoverButton) {
            workingPanel.show(recoverPanel);
        }
    }
}

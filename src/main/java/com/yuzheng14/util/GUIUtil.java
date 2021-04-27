package com.yuzheng14.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author yuzheng14
 */
public class GUIUtil {
    private static final String imageFolder="src/main/resources/img";
    /**
     * 检查一个输入框是否为空
     *
     * @param textField
     * @param input
     * @return
     */
    public static boolean checkEmpty(JTextField textField, String input) {
        String text = textField.getText().trim();
        if (text.length() == 0) {
            JOptionPane.showMessageDialog(null, input + " 不能为空");
            textField.grabFocus();
            return false;
        }
        return true;
    }

    /**
     * 检查一个组件内容是否为数字格式
     *
     * @param textField
     * @param input
     * @return
     */
    public static boolean checkNumber(JTextField textField, String input) {
        if (!(checkEmpty(textField, input))) {
            return false;
        }
        String text = textField.getText().trim();
        try {
            Integer.parseInt(text);
            return true;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, input + " 需要是整数");
            textField.grabFocus();
            return false;
        }
    }

    /**
     * TODO 感觉当组件内容非空且不为数字时此处会出现异常
     * 检查一个组件的内容是否为零，非空且不为零时返回ture
     *
     * @param textField
     * @param input
     * @return
     */
    public static boolean checkZero(JTextField textField, String input) {
        if (!checkNumber(textField, input)) {
            return false;
        }
        String text = textField.getText().trim();
        if (Integer.parseInt(text) == 0) {
            JOptionPane.showMessageDialog(null, input + " 不能为零");
            textField.grabFocus();
            return false;
        }
        return true;
    }

    /**
     * 给多个组件设置前景色
     * @param color
     * @param components
     */
    public static void setColor(Color color, JComponent... components) {
        for (JComponent c : components) {
            c.setForeground(color);
        }
    }

    /**
     * 给按钮设置图标和文本以及提示文字
     * @param btn
     * @param fileName
     * @param tip
     */
    public static void setImageIcon(JButton btn,String fileName,String tip){
        ImageIcon i=new ImageIcon(new File(imageFolder,fileName).getAbsolutePath());
        btn.setIcon(i);
        btn.setPreferredSize(new Dimension(61,81));
        btn.setToolTipText(tip);
        btn.setVerticalTextPosition(JButton.BOTTOM);
        btn.setHorizontalTextPosition(JButton.CENTER);
        btn.setText(tip);
    }

    /**
     * 快速显示一个面板的内容
     * @param panel
     * @param stretch 1为铺满屏幕
     */
    public static void showPanel(JPanel panel,double stretch){
        JFrame frame=new JFrame();
        frame.setSize(500,500);
        frame.setLocationRelativeTo(null);
        CenterPanel centerPanel=new CenterPanel(stretch);
        frame.setContentPane(centerPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        centerPanel.show(panel);
    }
    public static void showPanel(JPanel panel){
        showPanel(panel,0.85);
    }

}

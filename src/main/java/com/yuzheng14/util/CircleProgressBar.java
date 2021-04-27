package com.yuzheng14.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

/**
 * @author yuzheng14
 */
@Component
public class CircleProgressBar extends JPanel {
    @Value("0")
    private int minimumProgress;
    @Value("100")
    private int maximumProgress;
    private int progress;

    @Value("0%")
    private String progressText;

    private Color backgroundColor;
    private Color foregroundColor;

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;
        //开启抗锯齿
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int x = 0;
        int y = 0;
        int width = 0;
        int height = 0;
        int fontSize = 0;
        if (getWidth() >= getHeight()) {
            x = (getWidth() - getHeight()) / 2 + 25;
            y = 25;
            width = getHeight() - 50;
            height = getHeight() - 50;
            fontSize = getWidth() / 8;
        } else {
            x = 25;
            y = (getHeight() - getWidth()) / 2 + 25;
            width = getWidth() - 50;
            height = getWidth() - 50;
            fontSize = getHeight() / 8;
        }
        graphics2D.setStroke(new BasicStroke(20.0f));
        graphics2D.setColor(backgroundColor);
        graphics2D.drawArc(x, y, width, height, 0, 360);
        graphics2D.setColor(foregroundColor);
        graphics2D.drawArc(x, y, width, height, 90, -(int) (360 * ((progress * 1.0) / (maximumProgress - minimumProgress))));
        graphics2D.setFont(new Font("黑体", Font.BOLD, fontSize));
        FontMetrics fontMetrics = graphics2D.getFontMetrics();
        int digitalWidth = fontMetrics.stringWidth(progressText);
        int digitalAscent = fontMetrics.getAscent();
        graphics2D.setColor(foregroundColor);
        graphics2D.drawString(progressText, getWidth() / 2 - digitalWidth / 2, getHeight() / 2 + digitalAscent / 2);
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = Math.max(minimumProgress, Math.min(maximumProgress, progress));
        this.progressText = progress + "%";
        this.repaint();
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
        this.repaint();
    }

    public Color getForegroundColor() {
        return foregroundColor;
    }

    public void setForegroundColor(Color foregroundColor) {
        this.foregroundColor = foregroundColor;
        this.repaint();
    }
}

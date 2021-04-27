package com.yuzheng14.util;

import java.awt.*;

public class ColorUtil {
    private static final Color blue=Color.decode("#3399FF");
    private static final Color gray=Color.decode("#999999");
    private static final Color background=Color.decode("#eeeeee");
    private static final Color warning=Color.decode("#FF3333");

    public static Color getByPercentage(int percent){
        percent= Math.min(percent, 100);
        int r;
        int g;
        int b=51;
        float rate=percent/100f;
        r=(int)((255-51)*rate+51);
        g=255-r+51;
        return new Color(r,g,b);
    }

    public static Color getBlue() {
        return blue;
    }

    public static Color getBackground() {
        return background;
    }

    public static Color getGray() {
        return gray;
    }

    public static Color getWarning() {
        return warning;
    }
}

package com.yuzheng14.gui.panel;

import com.yuzheng14.BeforeTest;
import com.yuzheng14.util.GUIUtil;
import org.junit.Test;

public class ConfigTest extends BeforeTest {
    @Test
    public void show(){
        GUIUtil.showPanel(context.getBean("configPanel",ConfigPanel.class));
    }
}

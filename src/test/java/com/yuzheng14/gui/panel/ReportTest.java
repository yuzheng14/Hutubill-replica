package com.yuzheng14.gui.panel;

import com.yuzheng14.BeforeTest;
import com.yuzheng14.util.GUIUtil;
import org.junit.Test;

public class ReportTest extends BeforeTest {
    @Test
    public void test(){
        GUIUtil.showPanel(context.getBean("reportPanel",ReportPanel.class));
    }
}

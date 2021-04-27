package com.yuzheng14.gui.panel;

import com.yuzheng14.BeforeTest;
import com.yuzheng14.util.GUIUtil;
import org.junit.Test;

public class PanelTest extends BeforeTest {
    @Test
    public void showRecoverPanel() {
        GUIUtil.showPanel(context.getBean("recoverPanel",RecoverPanel.class));
    }
}

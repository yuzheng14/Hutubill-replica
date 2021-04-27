package com.yuzheng14.gui.panel;

import com.yuzheng14.BeforeTest;
import com.yuzheng14.util.GUIUtil;
import org.junit.Test;

public class BackupPanelTest extends BeforeTest {
    @Test
    public void show(){
        GUIUtil.showPanel(context.getBean("backupPanel",BackupPanel.class));
    }
}

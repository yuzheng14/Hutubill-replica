package com.yuzheng14.gui.model;

import com.yuzheng14.BeforeTest;
import org.junit.Test;

public class CategoryTableModelTest extends BeforeTest {
    @Test
    public void instantiateTest(){
        context.getBean("categoryTableModel",CategoryTableModel.class);
    }
}

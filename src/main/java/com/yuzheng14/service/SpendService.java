package com.yuzheng14.service;

import com.yuzheng14.dao.RecordDAO;
import com.yuzheng14.entity.Record;
import com.yuzheng14.gui.page.SpendPage;
import com.yuzheng14.util.DateUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yuzheng14
 */
@Service
public class SpendService {
    @Resource
    private RecordDAO recordDAO;
    @Resource
    private ConfigService configService;

    public SpendPage getSpendPage() {
        List<Record> thisMonthRecords = recordDAO.listThisMonth();
        List<Record> todayRecords = recordDAO.listToday();

        int thisMonthTotalDay = DateUtil.thisMonthTotalDay();

        int monthSpend = 0;
        int todaySpend = 0;
        int averageSpendPerDay = 0;
        int monthAvailable = 0;
        int dayAverageAvailable = 0;
        int monthLeftDay = 0;
        int usagePercentage = 0;

        int monthBudget = configService.getIntBudget();

        for (Record record :
                thisMonthRecords) {
            monthSpend += record.getSpend();
        }

        for (Record record :
                todayRecords) {
            todaySpend += record.getSpend();
        }

        averageSpendPerDay = monthSpend / thisMonthTotalDay;

        monthAvailable = monthBudget - monthSpend;

        monthLeftDay=DateUtil.thisMonthLeftDay();

        dayAverageAvailable = monthAvailable / monthLeftDay;
        usagePercentage = monthSpend * 100 / monthBudget;

        return new SpendPage(monthSpend, todaySpend, averageSpendPerDay, monthAvailable, dayAverageAvailable, monthLeftDay, usagePercentage);
    }
}

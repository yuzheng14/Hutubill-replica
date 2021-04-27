package com.yuzheng14.service;

import com.yuzheng14.dao.RecordDAO;
import com.yuzheng14.entity.Record;
import com.yuzheng14.util.DateUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author yuzheng14
 */
@Service
public class ReportService {
    @Resource
    private RecordDAO recordDAO;

    /**
     * 获取某一天的消费金额
     * @param date
     * @param monthRawData
     * @return
     */
    public int getDaySpend(Date date, List<Record> monthRawData){
        int daySpend=0;
        for (Record record :
                monthRawData) {
            if (record.getDate().equals(date)) {
                daySpend += record.getSpend();
            }
        }
        return daySpend;
    }

    /**
     * 获取一个月的消费记录
     * @return
     */
    public List<Record> listThisMOnthRecords(){
        List<Record> monthRawDate=recordDAO.listThisMonth();
        List<Record> result=new ArrayList<>();
        Date monthBegin= DateUtil.monthBegin();
        int monthTotalDay=DateUtil.thisMonthTotalDay();
        Calendar calendar=Calendar.getInstance();
        for (int i = 0; i < monthTotalDay; i++) {
            Record record=new Record();
            calendar.setTime(monthBegin);
            calendar.add(Calendar.DATE,i);
            Date eachDayOfThisMonth=calendar.getTime();
            int daySpend=getDaySpend(eachDayOfThisMonth,monthRawDate);
            record.setSpend(daySpend);
            result.add(record);
        }
        return result;
    }
}

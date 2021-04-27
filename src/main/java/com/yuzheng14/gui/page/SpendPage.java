package com.yuzheng14.gui.page;

/**
 * @author yuzheng14
 */
//@Component
public class SpendPage {
    //本月消费
    private final String monthSpend;
    //今日消费
    private final String todaySpend;
    //日均消费
    private final String averageSpendPerDay;
    //本月剩余
    private final String monthAvailable;
    //日均可用
    private final String dayAverageAvailable;
    //距离月末
    private final String monthLeftDay;
    //使用比例
    private final int usagePercentage;
    //是否超支
    private boolean overSpend =false;

    public SpendPage(int monthSpend,int todaySpend,int averageSpendPerDay,int monthAvailable,int dayAverageAvailable,int monthLeftDay,int usagePercentage){
        this.monthSpend="￥"+monthSpend;
        this.todaySpend="￥"+todaySpend;
        this.averageSpendPerDay="￥"+averageSpendPerDay;
        if (monthAvailable<0){
            overSpend =true;
        }
        if (!overSpend){
            this.monthAvailable="￥"+monthAvailable;
            this.dayAverageAvailable="￥"+dayAverageAvailable;
        }else {
            this.monthAvailable="超支"+(-monthAvailable);
            this.dayAverageAvailable="￥0";
        }
        this.monthLeftDay=monthLeftDay+"天";
        this.usagePercentage=usagePercentage;
    }

    public int getUsagePercentage() {
        return usagePercentage;
    }

    public String getAverageSpendPerDay() {
        return averageSpendPerDay;
    }

    public String getDayAverageAvailable() {
        return dayAverageAvailable;
    }

    public String getMonthAvailable() {
        return monthAvailable;
    }

    public String getMonthLeftDay() {
        return monthLeftDay;
    }

    public String getMonthSpend() {
        return monthSpend;
    }

    public String getTodaySpend() {
        return todaySpend;
    }

    public boolean isOverSpend() {
        return overSpend;
    }
}

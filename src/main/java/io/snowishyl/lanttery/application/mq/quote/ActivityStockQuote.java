package io.snowishyl.lanttery.application.mq.quote;

import java.io.Serializable;

/**
 * @program: quarkus-lanttery
 * @description: 活动库存扣减消息体
 * @author: YxYL
 * @create: 2023-10-14 21:36
 **/
public class ActivityStockQuote implements Serializable {
    
    private Long activityId;
    
    private Integer activityStockSurplus;

    public ActivityStockQuote() {
    }


    public ActivityStockQuote(Long activityId, Integer activityStockSurplus) {
        this.activityId = activityId;
        this.activityStockSurplus = activityStockSurplus;
    }

    public Integer getActivityStockSurplus() {
        return activityStockSurplus;
    }

    public void setActivityStockSurplus(Integer activityStockSurplus) {
        this.activityStockSurplus = activityStockSurplus;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }
}

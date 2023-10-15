package io.snowishyl.lanttery.domain.activity.entity.res;

import io.snowishyl.lanttery.common.R;
import io.snowishyl.lanttery.common.constants.Constants;

/**
 * @program: quarkus-lanttery
 * @description:
 * @author: YxYL
 * @create: 2023-10-14 10:31
 **/
public class ActivityPartakeRes extends R {
    private Integer activityStock;
    
    public ActivityPartakeRes(Integer activityStock) {
        super(Constants.ResponseCode.SUCCESS.getCode(), Constants.ResponseCode.SUCCESS.getInfo());
        this.activityStock = activityStock;
    }

    public ActivityPartakeRes(String code, String msg, Integer activityStock) {
        super(code, msg);
        this.activityStock = activityStock;
    }

    public Integer getActivityStock() {
        return activityStock;
    }

    public void setActivityStock(Integer activityStock) {
        this.activityStock = activityStock;
    }
}

package io.snowishyl.lanttery.domain.activity.service;

import io.snowishyl.lanttery.application.process.req.DrawProcessReq;
import io.snowishyl.lanttery.common.constants.Constants;
import io.snowishyl.lanttery.domain.activity.entity.res.ActivityPartakeRes;
import io.snowishyl.lanttery.domain.activity.entity.res.StockRes;

/**
 * @program: quarkus-lanttery
 * @description:
 * @author: YxYL
 * @create: 2023-10-14 10:53
 **/

public abstract class BaseActivityPartake extends ActivityPartakeSupport implements IActivityPartake {


    @Override
    public ActivityPartakeRes doPartake(DrawProcessReq req) {
        //redis库存扣减过滤
        Long activityId = req.getActivityId();
        Integer activityStock = this.getActivityStock(activityId);
        StockRes stockRes = stockByRedis(activityId, activityStock);
        if (!stockRes.getCode().equals(Constants.ResponseCode.SUCCESS.getCode())) {
            return new ActivityPartakeRes(stockRes.getCode(), stockRes.getMsg(), null);
        }
        //库存扣减(过滤)完毕，返回扣减结果
        return new ActivityPartakeRes(stockRes.getCode(), stockRes.getMsg(), stockRes.getStock());
    }

    protected abstract StockRes stockByRedis(Long activityId, Integer activityStock);


}

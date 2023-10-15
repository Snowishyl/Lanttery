package io.snowishyl.lanttery.domain.activity.service.impl;

import io.quarkus.redis.client.RedisClient;
import io.snowishyl.lanttery.common.constants.Constants;
import io.snowishyl.lanttery.common.constants.RedisKey;
import io.snowishyl.lanttery.domain.activity.entity.res.StockRes;
import io.snowishyl.lanttery.domain.activity.service.BaseActivityPartake;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 * @program: quarkus-lanttery
 * @description:
 * @author: YxYL
 * @create: 2023-10-14 10:53
 **/
@ApplicationScoped
public class ActivityPartakeImpl extends BaseActivityPartake {


    @Inject
    private RedisClient redisClient;

    @Override
    protected StockRes stockByRedis(Long activityId, Integer activityStock) {
        //将活动的库存放redis里
        String activityKey = RedisKey.KEY_LOTTERY_ACTIVITY_STOCK_COUNT(activityId);
        redisClient.setnx(activityKey.toString(), activityStock.toString());

        Integer stock = redisClient.decr(activityKey).toInteger();
        if (stock < 0) {
            //库存超卖了
            redisClient.incr(activityKey);
            return new StockRes(Constants.ResponseCode.OUT_OF_STOCK.getCode(), Constants.ResponseCode.OUT_OF_STOCK.getInfo(), null);
        }
                
        //扣减库存成功
        return new StockRes(Constants.ResponseCode.SUCCESS.getCode(), Constants.ResponseCode.SUCCESS.getInfo(), stock);
    }
}

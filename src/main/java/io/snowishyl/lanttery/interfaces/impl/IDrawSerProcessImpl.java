package io.snowishyl.lanttery.interfaces.impl;

import io.snowishyl.lanttery.application.mq.producer.ActivityStockProducer;
import io.snowishyl.lanttery.application.mq.quote.ActivityStockQuote;
import io.snowishyl.lanttery.application.process.req.DrawProcessReq;
import io.snowishyl.lanttery.application.process.res.DrawProcessRes;
import io.snowishyl.lanttery.common.constants.Constants;
import io.snowishyl.lanttery.domain.activity.service.IActivityPartake;
import io.snowishyl.lanttery.domain.activity.entity.res.ActivityPartakeRes;
import io.snowishyl.lanttery.domain.strategy.service.draw.IDrawExec;
import io.snowishyl.lanttery.interfaces.IDrawSerProcess;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;


/**
 * @program: quarkus-lanttery
 * @description:
 * @author: YxYL
 * @create: 2023-10-14 10:22
 **/
@ApplicationScoped
public class IDrawSerProcessImpl implements IDrawSerProcess {

    @Inject
    private IActivityPartake activityPartake;
    @Inject
    private IDrawExec draw;
    @Inject
    private ActivityStockProducer activityStockProducer;


    @Override
    public DrawProcessRes doDraw(DrawProcessReq req) {
        //进行库存扣减分布式锁检验
        ActivityPartakeRes partakeRes = activityPartake.doPartake(req);
        if (!partakeRes.getCode().equals(Constants.ResponseCode.SUCCESS.getCode())) {
            return new DrawProcessRes(partakeRes.getCode(), partakeRes.getMsg(), null);
        }
        //发送mq扣减活动库存
        activityStockProducer.duckActivityStockSend(new ActivityStockQuote(req.getActivityId(), partakeRes.getActivityStock()));

        //执行抽奖算法得到奖品
        DrawProcessRes res = draw.doDrawAlgorithm(req);

        //返回结果
        return res;
    }
}

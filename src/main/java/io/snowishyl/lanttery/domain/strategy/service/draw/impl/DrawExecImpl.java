package io.snowishyl.lanttery.domain.strategy.service.draw.impl;

import io.quarkus.redis.client.RedisClient;
import io.snowishyl.lanttery.common.constants.RedisKey;
import io.snowishyl.lanttery.domain.strategy.entity.vo.AwardRateVO;
import io.snowishyl.lanttery.domain.strategy.service.algorithm.IDrawAlgorithm;
import io.snowishyl.lanttery.domain.strategy.service.draw.BaseDraw;
import io.snowishyl.lanttery.infrastructure.po.StrategyDetail;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

/**
 * @program: quarkus-lanttery
 * @description:
 * @author: YxYL
 * @create: 2023-10-14 10:50
 **/
@ApplicationScoped
public class DrawExecImpl extends BaseDraw {
    
    @Inject
    private RedisClient redisClient;

    @Override
    protected AwardRateVO drawAlgorithm(Long activityId, Long strategyId, IDrawAlgorithm iDrawAlgorithm, List<String> excludeAwardIds) {
        String awardId = iDrawAlgorithm.randomDraw(strategyId, excludeAwardIds);

        // 判断抽奖结果
        if (null == awardId) {
            //抽奖未中的话，就将redis的库存加上去
            String activityKey = RedisKey.KEY_LOTTERY_ACTIVITY_STOCK_COUNT(activityId);
            redisClient.incr(activityKey);
            return null;
        }
        //如果成功的话就立马扣减库存
        boolean isSuccess = strategyDetailRepository.deductStock(strategyId, awardId);
        StrategyDetail detail = getStrategyDetailByStrategyIdAndAwardId(strategyId,awardId);

        return isSuccess ? new AwardRateVO(detail) : new AwardRateVO();
    }
}
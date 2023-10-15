package io.snowishyl.lanttery.domain.strategy.service.algorithm.impl;


import io.snowishyl.lanttery.common.constants.Constants;
import io.snowishyl.lanttery.domain.strategy.annotation.Strategy;
import io.snowishyl.lanttery.domain.strategy.service.algorithm.BaseAlgorithm;

import javax.inject.Singleton;
import java.util.List;

/**
 * @description: 单项随机概率抽奖，抽到一个已经排掉的奖品则未中奖
 * @author：小傅哥，微信：fustack
 * @date: 2021/8/28
 * @Copyright：公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
@Singleton
@Strategy(strategyMode = Constants.StrategyMode.SINGLE)
public class SingleRateRandomDrawAlgorithm extends BaseAlgorithm {

    @Override
    public String randomDraw(Long strategyId, List<String> excludeAwardIds) {

        // 获取策略对应的元祖
        String[] rateTuple = super.rateTupleMap.get(strategyId);
        assert rateTuple != null;

        // 随机索引
        int randomVal = this.generateSecureRandomIntCode(100);
        int idx = super.hashIdx(randomVal);

        // 返回结果
        String awardId = rateTuple[idx];

        // 如果中奖ID命中排除奖品列表，则返回NULL
        if (excludeAwardIds.contains(awardId)) {
            return null;
        }

        return awardId;
    }

}

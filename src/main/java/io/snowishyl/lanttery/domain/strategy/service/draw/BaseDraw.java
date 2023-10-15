package io.snowishyl.lanttery.domain.strategy.service.draw;

import io.snowishyl.lanttery.application.process.req.DrawProcessReq;
import io.snowishyl.lanttery.application.process.res.DrawProcessRes;
import io.snowishyl.lanttery.common.constants.Constants;
import io.snowishyl.lanttery.domain.strategy.entity.aggregates.StrategyRich;
import io.snowishyl.lanttery.domain.strategy.entity.vo.AwardRateVO;
import io.snowishyl.lanttery.domain.strategy.service.algorithm.IDrawAlgorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: quarkus-lanttery
 * @description:
 * @author: YxYL
 * @create: 2023-10-14 10:37
 **/

public abstract class BaseDraw extends DrawSupport implements IDrawExec {


    @Override
    public DrawProcessRes doDrawAlgorithm(DrawProcessReq req) {
        //获取策略id
        StrategyRich strategyRich = super.getStrategyRichByActivityId(req.getActivityId());

        //检查抽奖策略是否已经初始化到内存
        this.checkAndInitRateData(strategyRich.getStrategyId(), Constants.StrategyMode.SINGLE.getCode(), strategyRich.getRateVOS());

        //从config里拿到抽奖算法执行抽奖
        AwardRateVO awardRateVO = this.drawAlgorithm(req.getActivityId(), strategyRich.getStrategyId(), drawAlgorithmMap.get(Constants.StrategyMode.SINGLE.getCode()), new ArrayList<>());

        //得到奖品id
        return new DrawProcessRes(awardRateVO);
    }


    private void checkAndInitRateData(Long strategyId, Integer strategyMode, List<AwardRateVO> rateVOS) {
        // 根据抽奖策略模式，获取对应的抽奖服务
        IDrawAlgorithm drawAlgorithm = drawAlgorithmMap.get(strategyMode);

        // 判断已处理过的的数据
        if (drawAlgorithm.isExist(strategyId)) {
            return;
        }

        // 解析并初始化中奖概率数据到散列表
        drawAlgorithm.initRateTuple(strategyId, strategyMode, rateVOS);
    }

    protected abstract AwardRateVO drawAlgorithm(Long activityId, Long strategyId, IDrawAlgorithm iDrawAlgorithm, List<String> excludeAwardIds);


}

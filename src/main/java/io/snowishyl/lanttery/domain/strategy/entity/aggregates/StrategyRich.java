package io.snowishyl.lanttery.domain.strategy.entity.aggregates;

import io.snowishyl.lanttery.domain.strategy.entity.vo.AwardRateVO;

import java.util.List;

/**
 * @program: quarkus-lanttery
 * @description:
 * @author: YxYL
 * @create: 2023-10-14 20:14
 **/

public class StrategyRich {
    private Long strategyId;
    private List<AwardRateVO> rateVOS;

    public StrategyRich() {
    }

    public StrategyRich(Long strategyId, List<AwardRateVO> rateVOS) {
        this.strategyId = strategyId;
        this.rateVOS = rateVOS;
    }

    public Long getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(Long strategyId) {
        this.strategyId = strategyId;
    }

    public List<AwardRateVO> getRateVOS() {
        return rateVOS;
    }

    public void setRateVOS(List<AwardRateVO> rateVOS) {
        this.rateVOS = rateVOS;
    }
}

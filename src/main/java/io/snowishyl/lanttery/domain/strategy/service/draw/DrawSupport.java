package io.snowishyl.lanttery.domain.strategy.service.draw;

import io.snowishyl.lanttery.domain.strategy.entity.aggregates.StrategyRich;
import io.snowishyl.lanttery.domain.strategy.entity.vo.AwardRateVO;
import io.snowishyl.lanttery.infrastructure.po.Award;
import io.snowishyl.lanttery.infrastructure.po.StrategyDetail;
import io.snowishyl.lanttery.infrastructure.repository.IActivityRepository;
import io.snowishyl.lanttery.infrastructure.repository.IAwardRepository;
import io.snowishyl.lanttery.infrastructure.repository.IStrategyDetailRepository;

import javax.inject.Inject;
import java.util.List;

/**
 * @program: quarkus-lanttery
 * @description:
 * @author: YxYL
 * @create: 2023-10-14 10:37
 **/

public class DrawSupport extends DrawConfig {
    @Inject
    protected IStrategyDetailRepository strategyDetailRepository;
    @Inject
    protected IActivityRepository activityRepository;
    @Inject
    protected IAwardRepository awardRepository;


    protected StrategyRich getStrategyRichByActivityId(Long activityId) {
        Long strategyId = activityRepository.getStrategyIdByActivityId(activityId);
        List<StrategyDetail> detailList = strategyDetailRepository.list("strategyId", strategyId);
        List<AwardRateVO> rateVOS = detailList.stream().map(AwardRateVO::new).toList();
        return new StrategyRich(strategyId, rateVOS);
    }

    protected StrategyDetail getStrategyDetailByStrategyIdAndAwardId(Long strategyId, String awardId) {
        return strategyDetailRepository.find("strategyId=?1 and awardId = ?2", strategyId, awardId).firstResult();
    }

    protected Award getAward(String awardId) {
        return awardRepository.findById(Long.parseLong(awardId));
    }
}

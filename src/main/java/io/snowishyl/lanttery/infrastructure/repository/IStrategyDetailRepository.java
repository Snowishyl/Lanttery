package io.snowishyl.lanttery.infrastructure.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.snowishyl.lanttery.infrastructure.po.StrategyDetail;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
public class IStrategyDetailRepository implements PanacheRepository<StrategyDetail> {


    @Transactional
    public boolean deductStock(Long strategyId, String awardId) {
        int effect = update("awardSurplusCount = awardSurplusCount-1 where strategyId=?1 and awardId=?2 AND awardSurplusCount > 0", strategyId, awardId);
        return effect == 1;
    }
}

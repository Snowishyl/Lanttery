package io.snowishyl.lanttery.infrastructure.repository;


import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.snowishyl.lanttery.infrastructure.po.Activity;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
public class IActivityRepository implements PanacheRepository<Activity> {

    public Integer getActivityStock(Long activityId) {
        return find("activityId", activityId).firstResult().getStocksurpluscount();
    }


    public Long getStrategyIdByActivityId(Long activityId) {
        return find("activityId", activityId).firstResult().getStrategyid();
    }


    @Transactional
    public boolean duckActivityStock(Long activityId, Integer activityStockSurplus) {
        int effect = update("stockSurplusCount = ?1 where activityId = ?2 and stockSurplusCount >= ?1", activityStockSurplus, activityId);
        return effect == 1;
    }
}

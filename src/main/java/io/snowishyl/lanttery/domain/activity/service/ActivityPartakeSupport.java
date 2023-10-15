package io.snowishyl.lanttery.domain.activity.service;

import io.snowishyl.lanttery.infrastructure.repository.IActivityRepository;

import javax.inject.Inject;

/**
 * @program: quarkus-lanttery
 * @description:
 * @author: YxYL
 * @create: 2023-10-14 11:00
 **/

public class ActivityPartakeSupport {
    @Inject
    protected IActivityRepository activityRepository;

    protected Integer getActivityStock(Long activityId) {
        return activityRepository.getActivityStock(activityId);
    }


}

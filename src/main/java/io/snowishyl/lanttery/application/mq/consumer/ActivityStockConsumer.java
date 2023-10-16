package io.snowishyl.lanttery.application.mq.consumer;

import io.smallrye.reactive.messaging.annotations.Blocking;
import io.snowishyl.lanttery.application.mq.quote.ActivityStockQuote;
import io.snowishyl.lanttery.infrastructure.repository.IActivityRepository;
import io.vertx.core.json.JsonObject;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 * @program: quarkus-lanttery
 * @description: ??????MQ???
 * @author: YxYL
 * @create: 2023-10-14 21:43
 **/
@ApplicationScoped
public class ActivityStockConsumer {

    private static final Logger logger = LoggerFactory.getLogger(ActivityStockConsumer.class);

    @Inject
    private IActivityRepository activityRepository;

    @Incoming("activity-incoming")
    @Blocking
    public void duckActivityConsume(JsonObject jsonObject) {
        logger.info("扣减活动库存信息{}", jsonObject);
        ActivityStockQuote quote = jsonObject.getJsonObject("msg").mapTo(ActivityStockQuote.class);
        boolean effect = activityRepository.duckActivityStock(quote.getActivityId(), quote.getActivityStockSurplus());
        if (!effect) {
            logger.error("扣减活动库存失败");
        }
        logger.info("扣减活动库存成功");
    }

}

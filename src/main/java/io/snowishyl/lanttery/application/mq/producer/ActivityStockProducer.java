package io.snowishyl.lanttery.application.mq.producer;

import io.snowishyl.lanttery.application.mq.quote.ActivityStockQuote;
import io.vertx.core.json.JsonObject;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import javax.enterprise.context.RequestScoped;

//    @Channel(Constants.RabbitMQConstants.EXCHANGE_ACTIVITY_PARTAKE + "/" + Constants.RabbitMQConstants.TOPIC_ACTIVITY_PARTAKE)

/**
 * @program: quarkus-lanttery
 * @description: 活动扣减库存MQ生产者
 * @author: YxYL
 * @create: 2023-10-14 21:34
 **/
@RequestScoped
public class ActivityStockProducer {

    @Channel("activity-outgoing")
    Emitter<JsonObject> emitter;

    public JsonObject duckActivityStockSend(ActivityStockQuote quote) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.put("msg", quote);
        emitter.send(jsonObject);
        return jsonObject;
    }


}

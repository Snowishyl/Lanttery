package io.snowishyl.lanttery.common.constants;

public interface RedisKey {
    Long TIME_ONE_DAY = (long) (3600 * 12);

    String PART_KEY = "part";
    String MAX_PART_KEY = "part_max";

    String NOW_USER_KEY = "authorization:login:session:1";

    // 抽奖活动库存 Key
    String LOTTERY_ACTIVITY_STOCK_COUNT = "activity_stock_count_";

    public static String KEY_LOTTERY_ACTIVITY_STOCK_COUNT(Long activityId) {
        return LOTTERY_ACTIVITY_STOCK_COUNT + activityId;
    }

    // 抽奖活动库存锁 Key
    String LOTTERY_ACTIVITY_STOCK_COUNT_TOKEN = "activity_stock_count_token_";

    public static String KEY_LOTTERY_ACTIVITY_STOCK_COUNT_TOKEN(Long activityId, Integer stockUsedCount) {
        return LOTTERY_ACTIVITY_STOCK_COUNT_TOKEN + activityId + "_" + stockUsedCount;
    }

}

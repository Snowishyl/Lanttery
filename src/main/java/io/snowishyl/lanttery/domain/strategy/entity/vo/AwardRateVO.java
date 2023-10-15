package io.snowishyl.lanttery.domain.strategy.entity.vo;

import io.snowishyl.lanttery.infrastructure.po.StrategyDetail;

import java.math.BigDecimal;

public class AwardRateVO {

    /**
     * 奖品ID
     */
    private String awardId;

    /**
     * 中奖概率
     */
    private BigDecimal awardRate;

    /**
     * 奖品名称
     */
    private String awardName;

    public AwardRateVO() {
    }

    public AwardRateVO(StrategyDetail detail) {
        this.awardId = detail.getAwardid();
        this.awardName = detail.getAwardname();
        this.awardRate = BigDecimal.valueOf(detail.getAwardrate());
    }


    public AwardRateVO(String awardId, BigDecimal awardRate, String awardName) {
        this.awardId = awardId;
        this.awardRate = awardRate;
        this.awardName = awardName;
    }

    public String getAwardName() {
        return awardName;
    }

    public void setAwardName(String awardName) {
        this.awardName = awardName;
    }

    public String getAwardId() {
        return awardId;
    }

    public void setAwardId(String awardId) {
        this.awardId = awardId;
    }

    public BigDecimal getAwardRate() {
        return awardRate;
    }

    public void setAwardRate(BigDecimal awardRate) {
        this.awardRate = awardRate;
    }

    @Override
    public String toString() {
        return "AwardRateVO{" +
                "awardId='" + awardId + '\'' +
                ", awardRate=" + awardRate +
                '}';
    }
}
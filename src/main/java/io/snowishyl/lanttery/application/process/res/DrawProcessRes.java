package io.snowishyl.lanttery.application.process.res;

import io.snowishyl.lanttery.common.R;
import io.snowishyl.lanttery.common.constants.Constants;
import io.snowishyl.lanttery.domain.strategy.entity.vo.AwardRateVO;

import java.io.Serializable;

public class DrawProcessRes extends R implements Serializable {
    private AwardRateVO award;

    public AwardRateVO getAward() {
        return award;
    }

    public void setAward(AwardRateVO award) {
        this.award = award;
    }

    public DrawProcessRes(AwardRateVO award) {
        super(Constants.ResponseCode.SUCCESS.getCode(), Constants.ResponseCode.SUCCESS.getInfo());
        this.award = award;
    }

    public DrawProcessRes(String code, String msg, AwardRateVO award) {
        super(code, msg);
        this.award = award;
    }
}

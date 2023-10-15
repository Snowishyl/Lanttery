package io.snowishyl.lanttery.rpc;

import io.quarkus.grpc.GrpcService;
import io.smallrye.common.annotation.Blocking;
import io.smallrye.mutiny.Uni;
import io.snowishyl.lanttery.Lottery;
import io.snowishyl.lanttery.LotteryReply;
import io.snowishyl.lanttery.LotteryRequest;
import io.snowishyl.lanttery.application.process.req.DrawProcessReq;
import io.snowishyl.lanttery.application.process.res.DrawProcessRes;
import io.snowishyl.lanttery.domain.strategy.entity.vo.AwardRateVO;
import io.snowishyl.lanttery.interfaces.IDrawSerProcess;

import javax.inject.Inject;

/**
 * @program: quarkus-lanttery
 * @description:
 * @author: YxYL
 * @create: 2023-10-15 10:39
 **/
@GrpcService
public class LotteryGrpcService implements Lottery {
    @Inject
    private IDrawSerProcess drawSerProcess;

    @Blocking
    @Override
    public Uni<LotteryReply> doDrawLottery(LotteryRequest request) {
        DrawProcessRes drawProcessRes = drawSerProcess.doDraw(new DrawProcessReq(request.getUId(), request.getActivityId(), request.getMsg()));
        AwardRateVO award = drawProcessRes.getAward();
        String awardId = award.getAwardId();
        String awardName = award.getAwardName();
        return Uni.createFrom().item(LotteryReply.newBuilder().setAwardId(awardId).setAwardName(awardName).build());
    }
}

package io.snowishyl.lanttery.domain.strategy.service.draw;

import io.snowishyl.lanttery.application.process.req.DrawProcessReq;
import io.snowishyl.lanttery.application.process.res.DrawProcessRes;

/**
 * @program: quarkus-lanttery
 * @description:
 * @author: YxYL
 * @create: 2023-10-14 10:36
 **/

public interface IDrawExec {

    DrawProcessRes doDrawAlgorithm(DrawProcessReq req);
}

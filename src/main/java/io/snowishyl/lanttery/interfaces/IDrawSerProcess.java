package io.snowishyl.lanttery.interfaces;

import io.snowishyl.lanttery.application.process.req.DrawProcessReq;
import io.snowishyl.lanttery.application.process.res.DrawProcessRes;

/**
 * @program: quarkus-lanttery
 * @description:
 * @author: YxYL
 * @create: 2023-10-14 10:21
 **/
public interface  IDrawSerProcess {

    DrawProcessRes doDraw(DrawProcessReq req);
}

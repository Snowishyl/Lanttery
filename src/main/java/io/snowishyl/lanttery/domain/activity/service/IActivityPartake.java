package io.snowishyl.lanttery.domain.activity.service;

import io.snowishyl.lanttery.application.process.req.DrawProcessReq;
import io.snowishyl.lanttery.domain.activity.entity.res.ActivityPartakeRes;

public interface IActivityPartake {
    ActivityPartakeRes doPartake(DrawProcessReq req);
}

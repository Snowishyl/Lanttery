package io.snowishyl.lanttery.application.process;

import io.snowishyl.lanttery.application.process.req.DrawProcessReq;
import io.snowishyl.lanttery.application.process.res.DrawProcessRes;
import io.snowishyl.lanttery.common.R;
import io.snowishyl.lanttery.interfaces.IDrawSerProcess;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @program: quarkus-lanttery
 * @description:
 * @author: YxYL
 * @create: 2023-10-14 10:14
 **/
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/draw")
public class DrawResource {
    @Inject
    private IDrawSerProcess drawSerProcess;

    @POST
    @Path("doDraw")
    public R doDraw(DrawProcessReq req) {
        if (req == null) {
            throw new RuntimeException("参数为空");
        }
        DrawProcessRes doDrawRes = drawSerProcess.doDraw(req);
        return R.ok(doDrawRes.getMsg(), doDrawRes.getAward());
    }


}

//package io.snowishyl.common.exception;
//
//import io.snowishyl.common.R;
//
//import javax.inject.Singleton;
//import javax.ws.rs.core.Response;
//import javax.ws.rs.ext.ExceptionMapper;
//
//@Singleton
//public class DefaultExceptionHandler implements ExceptionMapper<Exception> {
//
//    @Override
//    public Response toResponse(Exception exception) {
//        return Response.ok(R.fail(exception.getMessage())).build();
//    }
//}

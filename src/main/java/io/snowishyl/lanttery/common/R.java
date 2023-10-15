package io.snowishyl.lanttery.common;


import io.snowishyl.lanttery.common.constants.Constants;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 响应信息主体
 *
 * @author Gffff
 */
public class R<T> implements Serializable {

    private static final long serialVersionUID = 1L;


    private String code;
    private String msg;
    private T data;
    private String time;


    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:MM:ss");

    public R() {
    }

    public R(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static <T> R<T> ok() {
        return restResult(null, Constants.ResponseCode.SUCCESS.getCode(), Constants.ResponseCode.SUCCESS.getInfo());
    }

    public static <T> R<T> ok(T data) {
        return restResult(data, Constants.ResponseCode.SUCCESS.getCode(), Constants.ResponseCode.SUCCESS.getInfo());
    }

    public static <T> R<T> ok(String msg) {
        return restResult(null, Constants.ResponseCode.SUCCESS.getCode(), msg);
    }

    public static <T> R<T> ok(String msg, T data) {
        return restResult(data, Constants.ResponseCode.SUCCESS.getCode(), msg);
    }

    public static <T> R<T> fail() {
        return restResult(null, Constants.ResponseCode.FAILED.getCode(), Constants.ResponseCode.FAILED.getInfo());
    }

    public static <T> R<T> fail(String msg) {
        return restResult(null, Constants.ResponseCode.FAILED.getCode(), msg);
    }

    public static <T> R<T> fail(T data) {
        return restResult(data, Constants.ResponseCode.FAILED.getCode(), Constants.ResponseCode.FAILED.getInfo());
    }

    public static <T> R<T> fail(String msg, T data) {
        return restResult(data, Constants.ResponseCode.FAILED.getCode(), msg);
    }

    public static <T> R<T> fail(String code, String msg) {
        return restResult(null, code, msg);
    }


    private static <T> R<T> restResult(T data, String code, String msg) {
        R<T> r = new R<>();
        r.setCode(code);
        r.setData(data);
        r.setMsg(msg);
        r.setTime(sdf.format(new Date()));
        return r;
    }

    public static <T> Boolean isError(R<T> ret) {
        return !isSuccess(ret);
    }

    public static <T> Boolean isSuccess(R<T> ret) {
        return Constants.ResponseCode.SUCCESS.getCode() == ret.getCode();
    }

    public static <T> R<T> ok(Constants.ResponseCode responseCode, String msg) {
        return restResult(null, responseCode.getCode(), msg);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}

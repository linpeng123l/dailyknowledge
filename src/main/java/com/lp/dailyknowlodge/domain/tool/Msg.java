package com.lp.dailyknowlodge.domain.tool;

/**
 * Created by jonathan on 2015/10/2.
 */
public class Msg {

    private boolean success;
    private String msg;
    private long errorType;
    public final static long PASSWORD_ERROR = 1;
    public final static long USERNAME_NOT_EXIST = 2;
    public final static long NOT_KOWN = 3;


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Msg() {
    }

    public Msg(boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }

    public long getErrorType() {
        return errorType;
    }

    public void setErrorType(long errorType) {
        this.errorType = errorType;
    }

    public  static Msg generateSuccMsg(){
        return  new Msg(true,"ok");
    }

}


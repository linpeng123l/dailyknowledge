package com.lp.dailyknowlodge.exception;

import com.lp.dailyknowlodge.domain.tool.Msg;

/**
 * Created by jonathan on 2015/10/2.
 */
public class MsgException extends  Exception {
    private Msg msg;
    public MsgException(Msg msg){
        super(msg.getMsg());
        this.msg  = msg;
    }
    public MsgException(String msg){
        super(msg);
        this.msg  = new Msg(false,msg);
    }
    public MsgException(String msg,long errorType){
        super(msg);
        this.msg  = new Msg(false,msg);
    }
    public MsgException(Exception e,String defaultMsg){
        if(e instanceof MsgException){
            this.msg = ((MsgException)e).getMsg();
        }else{
            this.msg  = new Msg(false,defaultMsg);
        }
    }
    public Msg getMsg() {
        return msg;
    }

    public void setMsg(Msg msg) {
        this.msg = msg;
    }
}

package com.lp.dailyknowlodge.service;

import android.os.Handler;
import android.os.Looper;

/**
 * Created by linpeng123l on 2015/11/17.
 */
public class BaseService {

    public static <T> void postSuccess(final ResultCallback<T> tResultCallback, final T response){
        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new Runnable() {
            @Override
            public void run() {
                tResultCallback.onSuccess(response);
            }
        });
    }

    public interface ResultCallback<T> {
        public void onSuccess(T response);
        public void onError(String msg);
    }

    public interface MsgResultCallback extends ResultCallback<String>{
    }

}

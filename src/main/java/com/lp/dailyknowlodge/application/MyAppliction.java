package com.lp.dailyknowlodge.application;

import android.app.Application;
import android.util.Log;

import com.facebook.drawee.backends.pipeline.Fresco;

import org.xutils.x;

/**
 * Created by linpeng123l on 2015/11/15.
 */
public class MyAppliction extends Application{
    //商贸城
    public final static int LOGIN_RESULT_SUCCESS = 0;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("linpeng123l", "s");

        Fresco.initialize(this);
        x.Ext.init(this);
        x.Ext.setDebug(true);
    }
}


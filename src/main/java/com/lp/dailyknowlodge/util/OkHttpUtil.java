package com.lp.dailyknowlodge.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lp.dailyknowlodge.domain.tool.Msg;
import com.lp.dailyknowlodge.exception.MsgException;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.CookieManager;
import java.net.CookiePolicy;

/**
 * Created by linpeng123l on 2015/11/17.
 */
public class OkHttpUtil {

    public static void getJsonObject(String url,FormEncodingBuilder formEncodingBuilder,JsonResponseCallback jsonResponseCallback) {
        OkHttpClient mOkHttpClient = new OkHttpClient();
        final Request request = new Request.Builder().url(url).post(formEncodingBuilder.build()).build();
        Call call = mOkHttpClient.newCall(request);
        mOkHttpClient.setCookieHandler(new CookieManager(null, CookiePolicy.ACCEPT_ORIGINAL_SERVER));
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
            }
            @Override
            public void onResponse(final Response response)  {
                try {
                    String jsonStr =  response.body().string();
                    JSONObject jsonObject = new JSONObject(jsonStr);
                    if (jsonObject.optBoolean("success", true) == false) {
                        Msg msg = new Gson().fromJson(jsonObject.toString(), new TypeToken<Msg>() {}.getType());
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public interface JsonResponseCallback{
        public void onResponse(JSONObject jsonObject) ;
        public void onFailure(Request request, IOException e);
    }

}

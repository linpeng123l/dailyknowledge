package com.lp.dailyknowlodge.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lp.dailyknowlodge.R;

import org.xutils.view.annotation.ContentView;

@ContentView(R.layout.activity_setting)
public class SettingActivity extends BaseToolbarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState,"设置");
    }
}

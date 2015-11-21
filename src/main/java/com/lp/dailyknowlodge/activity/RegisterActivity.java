package com.lp.dailyknowlodge.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.lp.dailyknowlodge.R;
import com.lp.dailyknowlodge.dialog.MyProgressDialog;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

@ContentView(R.layout.activity_register)
public class RegisterActivity extends BaseToolbarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, "注册");
    }

    public void registerClick(View view){
        MyProgressDialog.builderProgressDialogAndShow(this,"正在注册中...");
    }
}

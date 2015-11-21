package com.lp.dailyknowlodge.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;

import com.lp.dailyknowlodge.R;

import org.xutils.view.annotation.ContentView;

@ContentView(R.layout.activity_content)
public class ContentActivity extends BaseToolbarActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState,"详情");
        initView();
    }

    private void initView() {
        webView = (WebView) findViewById(R.id.content_wbeview);
        webView.loadUrl(getIntent().getStringExtra("contentUrl"));
    }
}

package com.lp.dailyknowlodge.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.facebook.common.internal.Preconditions;
import com.lp.dailyknowlodge.R;
import com.lp.dailyknowlodge.adapter.ArticleAdapterRcv;
import com.lp.dailyknowlodge.adapter.MyShareAdapterRcv;
import com.lp.dailyknowlodge.domain.Article;
import com.lp.dailyknowlodge.domain.Share;
import com.lp.dailyknowlodge.service.ArticleService;
import com.lp.dailyknowlodge.service.ShareService;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.List;

@ContentView(R.layout.activity_my_share)
public class MyShareActivity extends BaseToolbarActivity {
    @ViewInject(R.id.my_share_rcv)
    private RecyclerView recyclerView;
    private MyShareAdapterRcv myShareAdapterRcv;
    private List<Share> shares;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState,"我的分享");
        initView();
        ShareService.queryMyShares(shareResultCallback);
    }

    private void initView() {
        myShareAdapterRcv  = new MyShareAdapterRcv(this,null);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myShareAdapterRcv);
    }

    ShareService.ShareResultCallback shareResultCallback = new ShareService.ShareResultCallback() {
        @Override
        public void onSuccess(List<Share> response) {
            shares = response;
            myShareAdapterRcv.setShares(shares);
            myShareAdapterRcv.notifyDataSetChanged();
        }
        @Override
        public void onError(String msg) {
            Toast.makeText(MyShareActivity.this,msg,Toast.LENGTH_SHORT).show();
        }
    };
}

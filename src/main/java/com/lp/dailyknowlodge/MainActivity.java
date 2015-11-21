package com.lp.dailyknowlodge;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.lp.dailyknowlodge.activity.BaseActivity;
import com.lp.dailyknowlodge.activity.CollectionActivity;
import com.lp.dailyknowlodge.activity.ContentActivity;
import com.lp.dailyknowlodge.activity.HistoryActivity;
import com.lp.dailyknowlodge.activity.LoginActivity;
import com.lp.dailyknowlodge.activity.MyShareActivity;
import com.lp.dailyknowlodge.activity.ShareActivity;
import com.lp.dailyknowlodge.adapter.ArticleAdapterRcv;
import com.lp.dailyknowlodge.domain.Article;
import com.lp.dailyknowlodge.service.ArticleService;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.List;

@ContentView(R.layout.activity_main)
public class MainActivity extends BaseActivity {

    @ViewInject(R.id.drawer_lly_root)
    private LinearLayout rootLinearLayout;
    @ViewInject(R.id.main_rcv)
    private RecyclerView recyclerView;
    @ViewInject(R.id.toolbar)
    private Toolbar toolbar;
    @ViewInject(R.id.main_drawer)
    private DrawerLayout drawerLayout;
    private ArticleAdapterRcv articleAdapterRcv;
    private List<Article> articles;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        ArticleService.queryAllByPage(queryArticleCallback, 1);
    }

    /**
     * 查询文章的结果处理类
     */
    ArticleService.QueryArticleCallback queryArticleCallback = new ArticleService.QueryArticleCallback() {
        @Override
        public void onSuccess(List<Article> response) {
            articles = response;
            articleAdapterRcv.setArticles(articles);
            articleAdapterRcv.notifyDataSetChanged();
        }
        @Override
        public void onError(String msg) {
            Toast.makeText(MainActivity.this,msg,Toast.LENGTH_SHORT).show();
        }
    };

    private void initView() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        articleAdapterRcv = new ArticleAdapterRcv(this,null);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(articleAdapterRcv);
        articleAdapterRcv.setRecyclerOnItemClickListener(new ArticleAdapterRcv.RecyclerOnItemClickListener() {
            @Override
            public void OnItemClick(View view, int position, int num) {
                Intent intent = new Intent(MainActivity.this, ContentActivity.class);
                intent.putExtra("contentUrl", articles.get(position).getContentUrl());
                startActivity(intent);
            }
        });
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.abc_action_bar_home_description, R.string.abc_action_bar_home_description);
        actionBarDrawerToggle.syncState();
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
    }

    public void loginClick(View view){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivityForResult(intent, 1);
    }
    public void shareClick(View view){
        Intent intent = new Intent(this, ShareActivity.class);
        startActivity(intent);
    }
    public void myShareClick(View view){
        Intent intent = new Intent(this, MyShareActivity.class);
        startActivity(intent);
    }

    public void  collectionClick(View view){
        Intent intent = new Intent(this, CollectionActivity.class);
        startActivity(intent);
    }
    public void  historyClick(View view){
        Intent intent = new Intent(this, HistoryActivity.class);
        startActivity(intent);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

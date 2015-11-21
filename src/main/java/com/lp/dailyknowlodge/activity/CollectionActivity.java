package com.lp.dailyknowlodge.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.lp.dailyknowlodge.R;
import com.lp.dailyknowlodge.adapter.ArticleAdapterRcv;
import com.lp.dailyknowlodge.domain.Article;
import com.lp.dailyknowlodge.service.ArticleService;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.List;

@ContentView(R.layout.activity_collection)
public class CollectionActivity extends BaseToolbarActivity {
    @ViewInject(R.id.collection_rcv)
    private RecyclerView recyclerView;
    private ArticleAdapterRcv articleAdapterRcv;
    private List<Article> articles;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState,"收藏");
        initView();
        ArticleService.queryAllByPage(queryArticleCallback, 1);
    }

    private void initView() {
        articleAdapterRcv = new ArticleAdapterRcv(this,null);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(articleAdapterRcv);
        articleAdapterRcv.setRecyclerOnItemClickListener(new ArticleAdapterRcv.RecyclerOnItemClickListener() {
            @Override
            public void OnItemClick(View view, int position, int num) {
                Intent intent = new Intent(CollectionActivity.this, ContentActivity.class);
                intent.putExtra("contentUrl", articles.get(position).getContentUrl());
                startActivity(intent);
            }
        });
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
            Toast.makeText(CollectionActivity.this, msg, Toast.LENGTH_SHORT).show();
        }
    };
}

package com.lp.dailyknowlodge.service;

import com.lp.dailyknowlodge.domain.Article;
import com.lp.dailyknowlodge.util.OkHttpUtil;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.Request;

import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by linpe on 2015/11/2.
 */
public class ArticleService extends BaseService{
    public static void test(){

    }

    public static void queryAllByPage(QueryArticleCallback queryArticleCallback,int page){
        List<Article> articles = new ArrayList<>();
        Article article = new Article();
        article.setMasterImgUrl("http://img5.imgtn.bdimg.com/it/u=14843973,3615425030&fm=21&gp=0.jpg");
        article.setTitle("达芬奇睡眠法");
        article.setArticlelAbstract("达芬奇睡眠法");
        articles.add(article);
        article = new Article();
        article.setMasterImgUrl("http://img1.imgtn.bdimg.com/it/u=1228056409,1994734752&fm=21&gp=0.jpg");
        article.setTitle("10大著名的思想实验");
        article.setArticlelAbstract("10大著名的思想实验");
        articles.add(article);article = new Article();
        article.setMasterImgUrl("http://img1.imgtn.bdimg.com/it/u=2389375885,4024593952&fm=21&gp=0.jpg");
        article.setTitle("谷歌发展史");
        article.setArticlelAbstract("谷歌发展史");
        articles.add(article);article = new Article();
        article.setMasterImgUrl("http://s3.sinaimg.cn/middle/aad7d15agc75f386b8cb2&690");
        article.setTitle("五胡乱华");
        article.setArticlelAbstract("五胡乱华");
        articles.add(article);article = new Article();
        article.setMasterImgUrl("http://img.taopic.com/uploads/allimg/140221/234921-14022109223063.jpg");
        article.setTitle("计算机发展历史的四个阶段");
        article.setArticlelAbstract("计算机发展历史的四个阶段");
        articles.add(article);
        article = new Article();
        article.setMasterImgUrl("http://img5.imgtn.bdimg.com/it/u=14843973,3615425030&fm=21&gp=0.jpg");
        article.setTitle("达芬奇睡眠法");
        article.setArticlelAbstract("达芬奇睡眠法");
        articles.add(article);
        article = new Article();
        article.setMasterImgUrl("http://img1.imgtn.bdimg.com/it/u=1228056409,1994734752&fm=21&gp=0.jpg");
        article.setTitle("10大著名的思想实验");
        article.setArticlelAbstract("10大著名的思想实验");
        article = new Article();
        article.setMasterImgUrl("http://img1.imgtn.bdimg.com/it/u=1228056409,1994734752&fm=21&gp=0.jpg");
        article.setTitle("10大著名的思想实验");
        article.setArticlelAbstract("10大著名的思想实验");
        articles.add(article);article = new Article();
        article.setMasterImgUrl("http://img1.imgtn.bdimg.com/it/u=2389375885,4024593952&fm=21&gp=0.jpg");
        article.setTitle("谷歌发展史");
        article.setArticlelAbstract("谷歌发展史");
        articles.add(article);article = new Article();
        article.setMasterImgUrl("http://s3.sinaimg.cn/middle/aad7d15agc75f386b8cb2&690");
        article.setTitle("五胡乱华");
        article.setArticlelAbstract("五胡乱华");
        articles.add(article);article = new Article();
        article.setMasterImgUrl("http://img.taopic.com/uploads/allimg/140221/234921-14022109223063.jpg");
        article.setTitle("计算机发展历史的四个阶段");
        article.setArticlelAbstract("计算机发展历史的四个阶段");
        articles.add(article);
        article = new Article();
        article.setMasterImgUrl("http://img5.imgtn.bdimg.com/it/u=14843973,3615425030&fm=21&gp=0.jpg");
        article.setTitle("达芬奇睡眠法");
        article.setArticlelAbstract("达芬奇睡眠法");
        articles.add(article);
        article = new Article();
        article.setMasterImgUrl("http://img1.imgtn.bdimg.com/it/u=1228056409,1994734752&fm=21&gp=0.jpg");
        article.setTitle("10大著名的思想实验");
        article.setArticlelAbstract("10大著名的思想实验");
        articles.add(article);article = new Article();
        article.setMasterImgUrl("http://img1.imgtn.bdimg.com/it/u=2389375885,4024593952&fm=21&gp=0.jpg");
        article.setTitle("谷歌发展史");
        article.setArticlelAbstract("谷歌发展史");
        articles.add(article);article = new Article();
        article.setMasterImgUrl("http://s3.sinaimg.cn/middle/aad7d15agc75f386b8cb2&690");
        article.setTitle("五胡乱华");
        article.setArticlelAbstract("五胡乱华");
        articles.add(article);article = new Article();
        article.setMasterImgUrl("http://img.taopic.com/uploads/allimg/140221/234921-14022109223063.jpg");
        article.setTitle("计算机发展历史的四个阶段");
        article.setArticlelAbstract("计算机发展历史的四个阶段");
        articles.add(article);
        article = new Article();
        article.setMasterImgUrl("http://img5.imgtn.bdimg.com/it/u=14843973,3615425030&fm=21&gp=0.jpg");
        article.setTitle("达芬奇睡眠法");
        article.setArticlelAbstract("达芬奇睡眠法");
        articles.add(article);

        for(Article article1 : articles){
            article1.setContentUrl("http://m.cnbeta.com/view_446505.htm");
        }
        postSuccess(queryArticleCallback, articles);
        OkHttpUtil.getJsonObject("http://m.cnbeta.com/view_446505.htm", new FormEncodingBuilder().add("a","a"), new OkHttpUtil.JsonResponseCallback() {
            @Override
            public void onResponse(JSONObject jsonObject) {
//                postSuccess();
            }
            @Override
            public void onFailure(Request request, IOException e) {
            }
        });
    }
    public static void queryCollectionArticles(QueryArticleCallback queryArticleCallback,int page){
        List<Article> articles = new ArrayList<>();
        Article article = new Article();
        article.setMasterImgUrl("http://img5.imgtn.bdimg.com/it/u=14843973,3615425030&fm=21&gp=0.jpg");
        article.setTitle("达芬奇睡眠法");
        article.setArticlelAbstract("达芬奇睡眠法");
        articles.add(article);
        articles.add(article);
        articles.add(article);
        articles.add(article);
        articles.add(article);

        for(Article article1 : articles){
            article1.setContentUrl("http://m.cnbeta.com/view_446505.htm");
        }
        postSuccess(queryArticleCallback,articles);
    }

    public interface QueryArticleCallback extends ResultCallback<List<Article>>{
    }

}

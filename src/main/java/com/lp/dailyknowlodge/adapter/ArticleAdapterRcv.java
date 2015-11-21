package com.lp.dailyknowlodge.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.lp.dailyknowlodge.R;
import com.lp.dailyknowlodge.domain.Article;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by linpe on 2015/11/1.
 */
public class ArticleAdapterRcv extends RecyclerView.Adapter<ArticleAdapterRcv.ArticleViewHolder>{

    private RecyclerOnItemClickListener recyclerOnItemClickListener;
    private Context context;
    private List<Article> articles;

    public void setArticles(List<Article> articles) {
        if(articles==null){
            articles = new ArrayList<>();
        }
        this.articles = articles;
    }

    public ArticleAdapterRcv(Context context, List<Article> articles) {
        if(articles==null){
            articles = new ArrayList<>();
        }
        this.context = context;
        this.articles = articles;
    }

    @Override
    public ArticleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ArticleViewHolder holder = new ArticleViewHolder(LayoutInflater.from(context).inflate(R.layout.item_classify_choose,parent,false));
        return holder;
    }

    @Override
    public void onBindViewHolder(final ArticleViewHolder holder, int position) {
        holder.master_imgImageView.setImageURI(Uri.parse(articles.get(position).getMasterImgUrl()));
        holder.titleTextView.setText(articles.get(position).getTitle());
        if (recyclerOnItemClickListener!= null) {
           View.OnClickListener onClickListener = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getLayoutPosition();
                    int num = 0;
                    recyclerOnItemClickListener.OnItemClick(holder.master_imgImageView,pos,num);
                }
            };
            holder.master_imgImageView.getRootView().setOnClickListener(onClickListener);
            holder.titleParentCareView.setOnClickListener(onClickListener);
        }
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }
    public void setRecyclerOnItemClickListener(RecyclerOnItemClickListener recyclerOnItemClickListener) {
        this.recyclerOnItemClickListener = recyclerOnItemClickListener;
    }
    public interface RecyclerOnItemClickListener {
        void OnItemClick(View view,int position,int num);
    }
    class ArticleViewHolder extends RecyclerView.ViewHolder{
        SimpleDraweeView master_imgImageView;
        CardView titleParentCareView;
        TextView titleTextView;

        public ArticleViewHolder(View view) {
            super(view);
            master_imgImageView = (SimpleDraweeView)view.findViewById(R.id.item_main_rcv_img);
            titleTextView = (TextView) view.findViewById(R.id.item_main_tv_title);
            titleParentCareView = (CardView) view.findViewById(R.id.item_main_cv_title_parent);
            master_imgImageView.setAspectRatio(1.5f);
        }
    }
}

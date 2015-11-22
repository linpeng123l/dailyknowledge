package com.lp.dailyknowlodge;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

import static android.support.v7.widget.RecyclerView.*;

/**
 * Created by linpeng123l on 2015/11/22.
 */
public class LoadMoreRecycleView extends RecyclerView{
    private LayoutInflater layoutInflater;
    private View footView;
    private MyScrollListener myScrollListener;
    public LoadMoreRecycleView(Context context) {
        super(context);
        init(context);
    }

    public LoadMoreRecycleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public LoadMoreRecycleView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    public void setFootView(View footView) {
        this.footView = footView;
    }
    public void setMyScrollListener(MyScrollListener myScrollListener) {
        this.myScrollListener = myScrollListener;
    }

    private void init(Context context) {
        layoutInflater = LayoutInflater.from(context);
        initFootView();
        addOnScrollListener(myScrollListener);
    }
    //    public

    public View initFootView(){
        footView = layoutInflater.inflate(R.layout.layout_load_more,null);
        return footView;
    }
    public class MyScrollListener extends OnScrollListener{
        boolean isDown = false;
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) getLayoutManager();
            if(newState == SCROLL_STATE_IDLE){
                int lastVisibleItem = ((LinearLayoutManager) getLayoutManager()).findLastCompletelyVisibleItemPosition();
                int totalItem = getLayoutManager().getItemCount();
                if(totalItem==lastVisibleItem&&isDown){
                    if(footView==null){
                        initFootView();
                    }
                    linearLayoutManager.addView(footView);
                }
            }
        }
        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            if(dy>0){
                isDown = true;
            }else{
                isDown = false;
            }
        }
    }
}

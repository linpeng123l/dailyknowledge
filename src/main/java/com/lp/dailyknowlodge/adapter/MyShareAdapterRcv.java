package com.lp.dailyknowlodge.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lp.dailyknowlodge.R;
import com.lp.dailyknowlodge.domain.Share;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by linpe on 2015/11/1.
 * s
 */
public class MyShareAdapterRcv extends RecyclerView.Adapter<MyShareAdapterRcv.MyShareViewHolder>{

    private RecyclerOnItemClickListener recyclerOnItemClickListener;
    private Context context;
    private List<Share> shares;

    public void setShares(List<Share> shares) {
        if(shares==null){
            shares = new ArrayList<>();
        }
        this.shares = shares;
    }

    public MyShareAdapterRcv(Context context, List<Share> shares) {
        if(shares==null){
            shares = new ArrayList<>();
        }
        this.context = context;
        this.shares = shares;
    }

    @Override
    public MyShareViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyShareViewHolder(LayoutInflater.from(context).inflate(R.layout.item_my_share_content,parent,false));
    }

    @Override
    public void onBindViewHolder(final MyShareViewHolder holder, int position) {
        holder.titleTextView.setText(shares.get(position).getSubject());
        if (recyclerOnItemClickListener!= null) {
           View.OnClickListener onClickListener = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getLayoutPosition();
                    int num = 0;
                    recyclerOnItemClickListener.OnItemClick(holder.titleParentCareView,pos,num);
                }
            };
            holder.titleParentCareView.setOnClickListener(onClickListener);
        }
    }

    @Override
    public int getItemCount() {
        return shares.size();
    }

    public void setRecyclerOnItemClickListener(RecyclerOnItemClickListener recyclerOnItemClickListener) {
        this.recyclerOnItemClickListener = recyclerOnItemClickListener;
    }
    public interface RecyclerOnItemClickListener {
        void OnItemClick(View view, int position, int num);
    }
    class MyShareViewHolder extends RecyclerView.ViewHolder{
        CardView titleParentCareView;
        TextView titleTextView;

        public MyShareViewHolder(View view) {
            super(view);
            titleTextView = (TextView) view.findViewById(R.id.item_my_share_tv_title);
            titleParentCareView = (CardView) view.findViewById(R.id.item_my_share_cv_title_parent);
        }
    }
}

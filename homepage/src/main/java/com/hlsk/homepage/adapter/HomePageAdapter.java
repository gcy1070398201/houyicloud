package com.hlsk.homepage.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hlsk.homepage.R;
import com.hlsk.homepage.bean.HomePageBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: tianjun
 * @Date 2019/5/17
 * @Time 15:16
 */
public class HomePageAdapter extends RecyclerView.Adapter<HomePageAdapter.HomePageViewHolder> {
    List<HomePageBean> mHomePageList = new ArrayList<>();

    private LayoutInflater inflater;

    public HomePageAdapter(Context context, List<HomePageBean> mHomePageList) {
        inflater = LayoutInflater.from(context);
        this.mHomePageList = mHomePageList;
    }

    @NonNull
    @Override
    public HomePageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.homepage_main_item, null);
        return new HomePageViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull HomePageViewHolder homePageViewHolder, int position) {
        homePageViewHolder.textview.setText(mHomePageList.get(position).getTitle());
        homePageViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mItemClickListener != null) {
                    mItemClickListener.onItemClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        if (mHomePageList.size() == 0) {
            return 0;
        }
        return mHomePageList.size();
    }

    class HomePageViewHolder extends RecyclerView.ViewHolder {
        private TextView textview;

        public HomePageViewHolder(View itemView) {
            super(itemView);
            textview = (TextView) itemView.findViewById(R.id.homepage_item_tv_title);
        }
    }

    private ItemClickListener mItemClickListener;

    public interface ItemClickListener {
        public void onItemClick(int position);
    }

    public void setOnItemClickListener(ItemClickListener itemClickListener) {
        this.mItemClickListener = itemClickListener;

    }
}

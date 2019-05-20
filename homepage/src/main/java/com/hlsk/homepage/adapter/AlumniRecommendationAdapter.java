package com.hlsk.homepage.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hlsk.homepage.R;
import com.hlsk.homepage.bean.AlumniRecommendationBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: tianjun
 * @Date 2019/5/17
 * @Time 16:41
 */
public class AlumniRecommendationAdapter extends RecyclerView.Adapter<AlumniRecommendationAdapter.AlumniRecommendationViewHolder>  {
    List<AlumniRecommendationBean> mAlumniRecommendationBeanList = new ArrayList<>();
    private LayoutInflater inflater;

    public AlumniRecommendationAdapter(Context context, List<AlumniRecommendationBean> mHomePageList){
        inflater=LayoutInflater.from(context);
        this.mAlumniRecommendationBeanList=mHomePageList;
    }

    @NonNull
    @Override
    public AlumniRecommendationViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView=inflater.inflate(R.layout.homepage_main_item,null);
        return new AlumniRecommendationViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AlumniRecommendationViewHolder alumniRecommendationViewHolder, int position) {
        alumniRecommendationViewHolder.textview.setText(mAlumniRecommendationBeanList.get(position).getTitle());
        alumniRecommendationViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
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
        return mAlumniRecommendationBeanList.size();
    }


    class AlumniRecommendationViewHolder extends RecyclerView.ViewHolder {
        private TextView textview;

        public AlumniRecommendationViewHolder(View itemView) {
            super(itemView);
            textview = (TextView) itemView.findViewById(R.id.homepage_item_tv_title);
        }
    }

    private ItemClickListener mItemClickListener ;
    public interface ItemClickListener{
        public void onItemClick(int position) ;
    }
    public void setOnItemClickListener(ItemClickListener itemClickListener){
        this.mItemClickListener = itemClickListener ;

    }
}

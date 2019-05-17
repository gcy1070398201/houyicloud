package com.hlsk.connection.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hlsk.commonsdk.glide.ImageLoader;
import com.hlsk.connection.R;
import com.hlsk.connection.mode.ConTestMode;

import java.util.List;

/**
 * @author guchenyang
 * @Date 2019/5/17
 * @time 14:58
 */
public class ConContactAdapter extends BaseQuickAdapter<ConTestMode,BaseViewHolder> {
    Context context;

    public ConContactAdapter(Context context,int layoutResId, @Nullable List<ConTestMode> data) {
        super(layoutResId, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, ConTestMode item) {
        ImageView imageView=helper.getView(R.id.con_item_img);
        TextView con_item_name=helper.getView(R.id.con_item_name);
        TextView con_item_time=helper.getView(R.id.con_item_time);
        TextView con_item_content=helper.getView(R.id.con_item_content);
        ImageLoader.getImageLoader(context)
                .setCircleCrop()
                .loadUrl(item.getImageUrl(),imageView);
        con_item_name.setText(item.getTitle());
        con_item_content.setText(item.getContent());

    }
}

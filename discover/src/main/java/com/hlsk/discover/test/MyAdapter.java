package com.hlsk.discover.test;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hlsk.discover.R;

import java.util.List;

/**
 * author:gem
 * date:2019/5/16 15:15
 * desc:
 * version:
 */
public class MyAdapter extends BaseQuickAdapter<TestMode, BaseViewHolder> {
    public MyAdapter(int layoutResId, @Nullable List<TestMode> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, TestMode item) {
        helper.setText(R.id.discover_item_tv_loc, item.getContent());
        helper.setImageResource(R.id.discover_item_img_head, R.mipmap.discover_ic_launcher);
        helper.setText(R.id.discover_item_tv_title, item.getTitle());

    }
}

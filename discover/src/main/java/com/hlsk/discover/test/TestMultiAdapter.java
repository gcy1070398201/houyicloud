package com.hlsk.discover.test;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.util.MultiTypeDelegate;
import com.hlsk.discover.R;

import java.util.List;

/**
 * author:gem
 * date:2019/5/16 15:15
 * desc:
 * version:
 */
public class TestMultiAdapter extends BaseQuickAdapter<TestMultiMode, BaseViewHolder> {

    public TestMultiAdapter(@Nullable List<TestMultiMode> data) {
        super(data);
        setMultiTypeDelegate(new MultiTypeDelegate<TestMultiMode>() {
            @Override
            protected int getItemType(TestMultiMode testMode) {
                return testMode.getType();
            }
        });
        getMultiTypeDelegate()
                .registerItemType(0, R.layout.discover_item_test)
                .registerItemType(1, R.layout.discover_item_test_multi);
    }

    @Override
    protected void convert(BaseViewHolder helper, TestMultiMode item) {
        switch (helper.getItemViewType()) {
            case 0:
                helper.setText(R.id.discover_item_tv_loc, item.getContent());
                helper.setImageResource(R.id.discover_item_img_head, R.mipmap.discover_ic_launcher);
                helper.setText(R.id.discover_item_tv_title, item.getTitle());
                break;
            case 1:
                helper.setText(R.id.discover_item_multi_tv_loc, item.getContent());
                helper.setImageResource(R.id.discover_item_multi_img_head, R.mipmap.discover_ic_launcher);
                helper.setText(R.id.discover_item_multi_tv_title, item.getTitle());

                break;
        }
    }

}

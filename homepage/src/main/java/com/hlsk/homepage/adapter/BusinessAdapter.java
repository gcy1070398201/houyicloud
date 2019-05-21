package com.hlsk.homepage.adapter;

import android.support.annotation.Nullable;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hlsk.commonsdk.utils.ToastUtils;
import com.hlsk.homepage.R;
import com.hlsk.homepage.bean.TestBean;

import java.util.List;

/**
 * author:gem
 * date:2019/5/20 10:38
 * desc:
 * version:
 */
public class BusinessAdapter extends BaseQuickAdapter<TestBean, BaseViewHolder> {
    public BusinessAdapter(int layoutResId, @Nullable List<TestBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, TestBean item) {
        helper.setText(R.id.homepage_item_business_tv_name, item.getName() + "  |  " + item.getPost());
        helper.setText(R.id.homepage_item_business_tv_company, item.getCompany());
        helper.setText(R.id.homepage_item_business_tv_code, item.getCodes());
        helper.setText(R.id.homepage_item_business_tv_content, item.getContent());
        helper.setText(R.id.homepage_item_business_tv_type, item.getType());
        helper.setText(R.id.homepage_item_business_tv_time, item.getTimes());
        helper.getView(R.id.homepage_item_business_tv_contact).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.showToast("立即联系");
            }
        });
    }
}

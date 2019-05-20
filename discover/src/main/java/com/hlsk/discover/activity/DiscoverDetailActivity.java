package com.hlsk.discover.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.hlsk.commonsdk.base.BaseActivity;
import com.hlsk.discover.R;
import com.hlsk.discover.R2;
import com.hlsk.discover.core.RouterIntent;

import butterknife.BindView;

@Route(path = RouterIntent.DISCOVER_DETAIL)
public class DiscoverDetailActivity extends BaseActivity {
    @BindView(R2.id.discover_detail_tv_name)
    TextView tv_name;
    @BindView(R2.id.discover_detail_tv_company)
    TextView tv_company;
    @BindView(R2.id.discover_detail_tv_type)
    TextView tv_type;   //企业
    @BindView(R2.id.discover_detail_tv_focus)
    TextView tv_focus;
    @BindView(R2.id.discover_detail_tv_title)
    TextView tv_title;
    @BindView(R2.id.discover_detail_tv_content)
    TextView tv_content;
    @BindView(R2.id.discover_detail_tv_rv)
    RecyclerView recyclerView;
    @BindView(R2.id.discover_detail_tv_time)
    TextView tv_time;

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.discover_activity_detail;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {

    }
}

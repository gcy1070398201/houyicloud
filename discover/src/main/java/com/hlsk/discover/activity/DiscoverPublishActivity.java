package com.hlsk.discover.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.hlsk.commonsdk.base.BaseActivity;
import com.hlsk.discover.R;
import com.hlsk.discover.core.RouterIntent;

/**
 * 发布
 */
@Route(path = RouterIntent.DISCOVER_PUBLISH)
public class DiscoverPublishActivity extends BaseActivity {

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.discover_activity_edit;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {

    }
}

package com.hlsk.discover.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.hlsk.commonsdk.base.BaseActivity;
import com.hlsk.discover.R;
import com.hlsk.discover.R2;
import com.hlsk.discover.core.RouterIntent;

import butterknife.BindView;

/**
 * 发布
 */
@Route(path = RouterIntent.DISCOVER_PUBLISH)
public class DiscoverPublishActivity extends BaseActivity {

    @BindView(R2.id.discover_publish_et_title)
    TextInputEditText et_title;
    @BindView(R2.id.discover_publish_et_layout)
    TextInputLayout et_layout;

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.discover_activity_publish;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {

    }
}

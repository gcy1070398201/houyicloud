package com.hlsk.homepage.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.hlsk.commonsdk.base.BaseActivity;
import com.hlsk.commonsdk.core.RouterHub;
import com.hlsk.commonsdk.utils.ShowView;
import com.hlsk.homepage.R;
import com.hlsk.homepage.R2;
import com.hlsk.homepage.fragment.MainFragment;

@Route(path = RouterHub.HOMEPAGE_MAIN_ACTIVITY)
public class MainActivity extends BaseActivity {
    private ShowView showView;
    private TextView contentLayout;

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.homepage_main_activity;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R2.id.container, new MainFragment())
                    .commitNow();
        }
    }
}
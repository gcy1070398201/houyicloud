package com.hlsk.loginregister;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.hlsk.commonsdk.base.BaseActivity;

public class MainActivity extends BaseActivity {
    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.log_activity_main;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {

    }

    @Override
    public boolean useEventBus() {
        return false;
    }

}

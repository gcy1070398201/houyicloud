package com.hlsk.connection.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.hlsk.commonsdk.base.BaseActivity;
import com.hlsk.commonsdk.core.RouterHub;
import com.hlsk.connection.R;
import com.hlsk.connection.R2;
import com.hlsk.connection.fragment.MainFragment;

@Route(path = RouterHub.CONNECTION_MAIN_ACTIVITY)
public class MainActivity extends BaseActivity {


    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.con_main_activity;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R2.id.container, new MainFragment())
                    .commitNow();
        }
    }

    @Override
    public boolean useEventBus() {
        return false;
    }

}

package com.hlsk.discover.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.hlsk.commonsdk.base.BaseActivity;
import com.hlsk.commonsdk.core.RouterHub;
import com.hlsk.discover.R;
import com.hlsk.discover.R2;
import com.hlsk.discover.fragment.MainFragment;

@Route(path = RouterHub.DISCOVER_MAIN_ACTIVITY)
public class MainActivity extends BaseActivity {


    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.discover_main_activity;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        ARouter.getInstance().inject(this);
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

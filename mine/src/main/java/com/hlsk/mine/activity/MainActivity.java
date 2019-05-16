package com.hlsk.mine.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.hlsk.commonsdk.base.BaseActivity;
import com.hlsk.commonsdk.core.RouterHub;
import com.hlsk.mine.R;
import com.hlsk.mine.R2;

import butterknife.BindView;

@Route(path = RouterHub.MINE_MAIN_ACTIVITY)
public class MainActivity extends BaseActivity {


    @BindView(R2.id.tv_test)
    TextView tvTest;

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.mine_main_fragment;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
//        if (savedInstanceState == null) {
//            getSupportFragmentManager().beginTransaction()
//                    .replace(R2.id.container, new MainFragment())
//                    .commitNow();
//        }
        tvTest.setText(R.string.mine_app_name);
    }

    @Override
    public boolean useEventBus() {
        return false;
    }


}

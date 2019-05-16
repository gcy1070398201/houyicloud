package com.hlsk.mine.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.hlsk.commonsdk.base.BaseActivity;
import com.hlsk.commonsdk.core.RouterHub;
import com.hlsk.commonsdk.glide.ImageLoader;
import com.hlsk.mine.R;
import com.hlsk.mine.R2;

import butterknife.BindView;
import butterknife.OnClick;

@Route(path = RouterHub.MINE_MAIN_ACTIVITY)
public class MainActivity extends BaseActivity {


    @BindView(R2.id.tv_test)
    TextView tvTest;
    @BindView(R2.id.mini_img)
    ImageView imageView;

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.mine_main_fragment;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {

        tvTest.setText(R.string.mine_app_name);
        ImageLoader.getImageLoader(this)
                .setRadius(10)
                .loadUrl("http://5b0988e595225.cdn.sohucs.com/images/20171202/a1cc52d5522f48a8a2d6e7426b13f82b.gif",imageView);

    }

    @Override
    public boolean useEventBus() {
        return false;
    }

    @OnClick({R2.id.tv_test})
    public void onClickView(View view){

        ARouter.getInstance().build(RouterHub.MINE_MAIN_WEBVIEW_ACTIVITY)
                .withString("url","http://www.baidu.com").navigation();
    }


}

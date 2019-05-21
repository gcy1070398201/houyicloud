package com.hlsk.discover.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.hlsk.commonsdk.base.BaseActivity;
import com.hlsk.discover.R;
import com.hlsk.discover.R2;
import com.hlsk.discover.core.RouterIntent;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 发布
 */
@Route(path = RouterIntent.DISCOVER_PUBLISH)
public class DiscoverPublishActivity extends BaseActivity {


    @BindView(R2.id.discover_tv_push)
    TextView discoverPush;
    @BindView(R2.id.discover_tv_resources)
    TextView discoverRresources;
    @BindView(R2.id.discover_tv_demand)
    TextView discoverDemand;

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.discover_edit_layout;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {

    }
    @OnClick({R2.id.discover_tv_push,R2.id.discover_tv_resources,R2.id.discover_tv_demand})
    public void onViewClick(View view){
        if (view.getId()==R.id.discover_tv_push){

        }else if (view.getId()==R.id.discover_tv_resources){
            discoverRresources.setTextColor(this.getResources().getColor(R.color.discover_color_a52b2f));
            discoverDemand.setTextColor(this.getResources().getColor(R.color.discover_color_999999));
            discoverRresources.setBackground(this.getResources().getDrawable(R.drawable.discover_click_resources_bg));
            discoverDemand.setBackground(this.getResources().getDrawable(R.drawable.discover_unclick_demand_bg));
        }else if (view.getId()==R.id.discover_tv_demand){
            discoverRresources.setTextColor(this.getResources().getColor(R.color.discover_color_999999));
            discoverDemand.setTextColor(this.getResources().getColor(R.color.discover_color_a52b2f));
            discoverRresources.setBackground(this.getResources().getDrawable(R.drawable.discover_unclick_resources_bg));
            discoverDemand.setBackground(this.getResources().getDrawable(R.drawable.discover_click_demand_bg));
        }

    }
}

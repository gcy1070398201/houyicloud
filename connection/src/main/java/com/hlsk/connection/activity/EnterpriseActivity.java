package com.hlsk.connection.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.hlsk.commonsdk.base.BaseActivity;
import com.hlsk.connection.R;
import com.hlsk.connection.R2;
import com.hlsk.connection.adapter.ConContactAdapter;
import com.hlsk.connection.mode.ConTestMode;
import com.hlsk.connection.util.ConRouterHub;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 上下游企业
 *
 * @author guchenyang
 * @Date 2019/5/20
 * @time 17:24
 */
@Route(path = ConRouterHub.con_Enterprise_activity)
public class EnterpriseActivity extends BaseActivity {
    @BindView(R2.id.public_toolbar_back)
    RelativeLayout conToolbarBack;
    @BindView(R2.id.public_toolbar_title)
    TextView conToolbarTitle;
    @BindView(R2.id.public_toolbar)
    Toolbar publicToolbar;
    @BindView(R2.id.con_enterprise_list)
    RecyclerView conEnterpriseList;
    @BindView(R2.id.con_enterprise_list_sr)
    SmartRefreshLayout conEnterpriseListSr;
    @Autowired(name = "type")
    String type;

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.enterprise_layout;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {

        if (type.equals("1")){
            conToolbarTitle.setText("上游企业");
        }else if (type.equals("2")){
            conToolbarTitle.setText("下游企业");
        }
        initRecyclerView();
        List<ConTestMode> conTestModeList=new ArrayList<>();
        ConTestMode conTestMode=new ConTestMode();
        conTestMode.setContent("张三|董事长");
        conTestMode.setTitle("测试1");
        conTestMode.setImageUrl("http://img2.imgtn.bdimg.com/it/u=2850936076,2080165544&fm=206&gp=0.jpg");
        ConTestMode conTestMode2=new ConTestMode();
        conTestMode2.setContent("李四|财务总监");
        conTestMode2.setTitle("测试2");
        conTestMode2.setImageUrl("http://img3.imgtn.bdimg.com/it/u=698582197,4250615262&fm=206&gp=0.jpg");
        conTestModeList.add(conTestMode);
        conTestModeList.add(conTestMode2);
        ConContactAdapter conContactAdapter=new ConContactAdapter(this,R.layout.enterprise_list_item_layout,conTestModeList);
        conEnterpriseList.setAdapter(conContactAdapter);
    }
    @OnClick({R2.id.public_toolbar_back})
    public void onViewClick(View view) {
        this.finish();
    }
    private void initRecyclerView(){
        conEnterpriseList.setLayoutManager(new LinearLayoutManager(this));
        conEnterpriseListSr.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                refreshLayout.getLayout().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        conEnterpriseListSr.finishLoadMore();
                    }
                },1500);
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                refreshLayout.getLayout().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        conEnterpriseListSr.finishRefresh();
                    }
                },1500);
            }
        });
    }
}

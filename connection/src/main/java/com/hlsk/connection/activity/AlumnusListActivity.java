package com.hlsk.connection.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
 * 首页-专题
 *
 * @author guchenyang
 * @Date 2019/5/20
 * @time 16:19
 */
@Route(path = ConRouterHub.con_AlumnusList_activity)
public class AlumnusListActivity extends BaseActivity {

    @BindView(R2.id.public_toolbar_back)
    RelativeLayout conToolbarBack;
    @BindView(R2.id.public_toolbar_title)
    TextView conToolbarTitle;
    @BindView(R2.id.con_alumnus_list_tv)
    TextView conAlumnusListTv;
    @BindView(R2.id.con_alumnus_list_hot)
    RecyclerView conAlumnusListHot;
    @BindView(R2.id.con_alumnus_list_content)
    RecyclerView conAlumnusListContent;
    @BindView(R2.id.con_alumnus_list_sr)
    SmartRefreshLayout conAlumnusListSr;
    @Autowired(name = "info")
    Bundle bundle;
    String type="";
    String name="";

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.alumnus_list_layout;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        initRecyclerView();
        if (bundle!=null){
            type=bundle.getString("type");
            name=bundle.getString("name");
        }
        if (type.equals("1")){
            conAlumnusListTv.setText(name);
        }else {
            conAlumnusListTv.setText("后E 推荐");
        }
        conToolbarTitle.setText(name);

        List<ConTestMode> conTestModeList=new ArrayList<>();
        ConTestMode conTestMode=new ConTestMode();
        conTestMode.setContent("啊建设南大街撒");
        conTestMode.setTitle("测试1");
        conTestMode.setImageUrl("http://img2.imgtn.bdimg.com/it/u=2850936076,2080165544&fm=206&gp=0.jpg");
        ConTestMode conTestMode2=new ConTestMode();
        conTestMode2.setContent("啊建设南大街撒");
        conTestMode2.setTitle("测试2");
        conTestMode2.setImageUrl("http://img3.imgtn.bdimg.com/it/u=698582197,4250615262&fm=206&gp=0.jpg");
        conTestModeList.add(conTestMode);
        conTestModeList.add(conTestMode2);
        ConContactAdapter conContactAdapter=new ConContactAdapter(this,R.layout.con_home_item_layout,conTestModeList);
        conAlumnusListHot.setAdapter(conContactAdapter);
        conAlumnusListContent.setAdapter(conContactAdapter);
    }
    @OnClick({R2.id.public_toolbar_back})
    public void onViewClick(View view) {
        this.finish();
    }

    private void initRecyclerView(){
        conAlumnusListHot.setLayoutManager(new LinearLayoutManager(this));
        conAlumnusListContent.setLayoutManager(new LinearLayoutManager(this));
        conAlumnusListSr.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                refreshLayout.getLayout().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        conAlumnusListSr.finishLoadMore();
                    }
                },1500);
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                refreshLayout.getLayout().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        conAlumnusListSr.finishRefresh();
                    }
                },1500);
            }
        });
    }
}

package com.hlsk.connection.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.hlsk.commonsdk.base.BaseLazyLoadFragment;
import com.hlsk.commonsdk.core.RouterHub;
import com.hlsk.connection.R;
import com.hlsk.connection.R2;
import com.hlsk.connection.adapter.ConContactAdapter;
import com.hlsk.connection.mode.ConTestMode;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


/**
 * ================================================
 * Description:
 * <p>
 * Created by MVPArmsTemplate on 05/14/2019 15:35
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms">Star me</a>
 * <a href="https://github.com/JessYanCoding/MVPArms/wiki">See me</a>
 * <a href="https://github.com/JessYanCoding/MVPArmsTemplate">模版请保持更新</a>
 * ================================================
 */

@Route(path = RouterHub.CONNECTION_MAIN_FRAGMENT)
public class MainFragment extends BaseLazyLoadFragment {


    @BindView(R2.id.con_tv_alumnus)
    TextView conTvAlumnus;
    @BindView(R2.id.con_tv_industry)
    TextView conTvIndustry;
    @BindView(R2.id.con_tv_enterprise)
    TextView conTvEnterprise;
    @BindView(R2.id.con_info_rv)
    RecyclerView conInfoRv;
    @BindView(R2.id.con_info_sr)
    SmartRefreshLayout conSmartRefreshLayout;

    @Override
    public View initView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.con_main_fragment, container, false);
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        super.initData(savedInstanceState);

    }

    private void initSmartRefresh(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        conInfoRv.setLayoutManager(linearLayoutManager);
        conSmartRefreshLayout.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                refreshLayout.getLayout().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        conSmartRefreshLayout.finishLoadMore();
                    }
                },1500);
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                refreshLayout.getLayout().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        conSmartRefreshLayout.finishRefresh();
                    }
                },1500);
            }
        });
    }
    private void initData(){
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
        ConContactAdapter conContactAdapter=new ConContactAdapter(getActivity(),R.layout.con_home_item_layout,conTestModeList);
        conInfoRv.setAdapter(conContactAdapter);
    }

    @Override
    protected void lazyLoadData() {
        initSmartRefresh();
        initData();
    }
}

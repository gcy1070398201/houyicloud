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
import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hlsk.commonsdk.base.BaseLazyLoadFragment;
import com.hlsk.commonsdk.core.RouterHub;
import com.hlsk.connection.R;
import com.hlsk.connection.R2;
import com.hlsk.connection.adapter.ConContactAdapter;
import com.hlsk.connection.mode.ConTestMode;
import com.hlsk.connection.util.ConRouterHub;
import com.hlsk.connection.util.ConRouterUtil;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;


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
    @BindView(R2.id.con_tv_up_enterprise)
    TextView conTvUpEnterprise;
    @BindView(R2.id.con_tv_down_enterprise)
    TextView conTvDownEnterprise;
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

    @OnClick({R2.id.con_tv_alumnus,R2.id.con_tv_industry,R2.id.con_tv_up_enterprise,
            R2.id.con_tv_down_enterprise})
    public void onViewClick(View view){
        if (view.getId()==R.id.con_tv_alumnus){
            ConRouterUtil.go(ConRouterHub.con_Alumnus_activity,"type","1");
        }else if (view.getId()==R.id.con_tv_industry){
            ConRouterUtil.go(ConRouterHub.con_Alumnus_activity,"type","2");
        }else if (view.getId()==R.id.con_tv_up_enterprise){
            ConRouterUtil.go(ConRouterHub.con_Enterprise_activity,"type","1");
        }else if (view.getId()==R.id.con_tv_down_enterprise){
            ConRouterUtil.go(ConRouterHub.con_Enterprise_activity,"type","2");
        }
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
        conContactAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ARouter.getInstance().build(ConRouterHub.con_Alumnus_activity)
                        .withString("title","后E 校友录")
                        .withString("type","1")
                        .navigation();
            }
        });
    }

    @Override
    protected void lazyLoadData() {
        initSmartRefresh();
        initData();
    }
}

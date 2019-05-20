package com.hlsk.homepage.fragment;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.hlsk.commonsdk.base.BaseLazyLoadFragment;
import com.hlsk.commonsdk.core.RouterHub;
import com.hlsk.commonsdk.utils.ShowView;
import com.hlsk.commonsdk.utils.ToastUtils;
import com.hlsk.homepage.R;
import com.hlsk.homepage.R2;
import com.hlsk.homepage.adapter.AlumniRecommendationAdapter;
import com.hlsk.homepage.adapter.HomePageAdapter;
import com.hlsk.homepage.bean.AlumniRecommendationBean;
import com.hlsk.homepage.bean.HomePageBean;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import cn.bingoogolapple.bgabanner.BGABanner;

@Route(path = RouterHub.HOMEPAGE_MAIN_FRAGMENT)
public class MainFragment extends BaseLazyLoadFragment implements ShowView.RetryListerner {
    @BindView(R2.id.popular_supply_and_demand)
    RecyclerView mainRv;
    @BindView(R2.id.showView)
    ShowView showView;
    @BindView(R2.id.smartrefresh)
    SmartRefreshLayout smartrefresh;
    @BindView(R2.id.alumni_recommendation)
    RecyclerView alumniRecommendationRv;
    @BindView(R2.id.homepage_banner_content)
    BGABanner bannerContent;

    private View rootView;
    private List<HomePageBean> mHomePageList;
    private List<AlumniRecommendationBean> mAlumniRecommendationBeanList;

    private HomePageAdapter mHomePageAdapter;
    private AlumniRecommendationAdapter mAlumniRecommendationAdapter;

    @Override
    public View initView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle
            savedInstanceState) {
        rootView = inflater.inflate(R.layout.homepage_main_fragment, container, false);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        showView.setOnRetryListener(this);//设置监听
        if (!isNetworkConnected(getActivity())) {
            showView.setVisibility(View.VISIBLE);
            showView.show(ShowView.NO_NET);
        } else {
            showView.setVisibility(View.GONE);
        }
        initData();
    }

    private void initData() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        mainRv.setLayoutManager(linearLayoutManager);

//        loadData();
        mHomePageList = new ArrayList<>();
        mHomePageAdapter = new HomePageAdapter(getActivity(), mHomePageList);
        mainRv.setLayoutManager(new LinearLayoutManager(getActivity()));//设置布局管理器
        mainRv.setAdapter(mHomePageAdapter);
        mHomePageAdapter.setOnItemClickListener(new HomePageAdapter.ItemClickListener() {
            @Override
            public void onItemClick(int position) {
                ToastUtils.toastShowShort("热门供需选择第" + (position + 1) + "项");
            }
        });

        mAlumniRecommendationBeanList = new ArrayList<>();
        mAlumniRecommendationAdapter = new AlumniRecommendationAdapter(getActivity(), mAlumniRecommendationBeanList);
        alumniRecommendationRv.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        alumniRecommendationRv.setAdapter(mAlumniRecommendationAdapter);
        mAlumniRecommendationAdapter.setOnItemClickListener(new AlumniRecommendationAdapter.ItemClickListener() {

            @Override
            public void onItemClick(int position) {
                ToastUtils.toastShowShort("校友推荐" +position + "");
            }
        });

        bannerContent.setDelegate(new BGABanner.Delegate() {
            @Override
            public void onBannerItemClick(BGABanner banner, View itemView, @Nullable Object model, int position) {
                ToastUtils.toastShowShort("点击了第" + (position + 1) + "页");
            }
        });
    }


    private void loadData() {
        HomePageBean homePageBean;
        for (int i = 0; i < 10; i++) {
            homePageBean = new HomePageBean();
            homePageBean.setTitle("item:" + i);
            mHomePageList.add(homePageBean);
        }
//        mAlumniRecommendationBeanList = new ArrayList<>();
        AlumniRecommendationBean alumniRecommendationBean;
        for (int i = 0; i < 10; i++) {

            alumniRecommendationBean = new AlumniRecommendationBean();
            alumniRecommendationBean.setTitle("item:" + i);
            mAlumniRecommendationBeanList.add(alumniRecommendationBean);
        }
        List<View> views = new ArrayList<>();
        views.add(View.inflate(getActivity(), R.layout.homepage_layout_guide, null));
        views.add(View.inflate(getActivity(), R.layout.homepage_layout_guide, null));
        views.add(View.inflate(getActivity(), R.layout.homepage_layout_guide, null));
        bannerContent.setData(views);
    }

    @Override
    protected void lazyLoadData() {
        loadData();
    }

    @Override
    public void retry() {

        Log.i("重试", "刷新");
        if (!isNetworkConnected(getActivity())) {
            showView.show(ShowView.NO_NET);
        } else {
            showView.setVisibility(View.GONE);
        }
    }

    public boolean isNetworkConnected(Context context) {
        if (context != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
            if (mNetworkInfo != null) {
                return mNetworkInfo.isAvailable();
            }
        }
        return false;
    }

    @OnClick(R2.id.showView)
    public void onClick() {

    }

}

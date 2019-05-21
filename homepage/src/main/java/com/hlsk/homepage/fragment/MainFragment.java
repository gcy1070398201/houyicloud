package com.hlsk.homepage.fragment;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hlsk.commonsdk.base.BaseLazyLoadFragment;
import com.hlsk.commonsdk.core.RouterHub;
import com.hlsk.commonsdk.utils.ShowView;
import com.hlsk.commonsdk.utils.ToastUtils;
import com.hlsk.homepage.R;
import com.hlsk.homepage.R2;
import com.hlsk.homepage.adapter.AlumniRecommendationAdapter;
import com.hlsk.homepage.adapter.BusinessAdapter;
import com.hlsk.homepage.adapter.HomePageAdapter;
import com.hlsk.homepage.bean.AlumniRecommendationBean;
import com.hlsk.homepage.bean.HomePageBean;
import com.hlsk.homepage.bean.TestBean;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import cn.bingoogolapple.bgabanner.BGABanner;

@Route(path = RouterHub.HOMEPAGE_MAIN_FRAGMENT)
public class MainFragment extends BaseLazyLoadFragment implements ShowView.RetryListerner {
    @BindView(R2.id.popular_supply_and_demand)
    RecyclerView recyclerView;
    @BindView(R2.id.showView)
    ShowView showView;
    @BindView(R2.id.smartrefresh)
    SmartRefreshLayout smartrefresh;
    @BindView(R2.id.alumni_recommendation)
    RecyclerView alumniRecommendationRv;
    @BindView(R2.id.homepage_banner_content)
    BGABanner bannerContent;

    private View rootView;
    private List<HomePageBean> mHomePageList = new ArrayList<>();
    private List<AlumniRecommendationBean> mAlumniRecommendationBeanList;

    private HomePageAdapter mHomePageAdapter;
    private AlumniRecommendationAdapter mAlumniRecommendationAdapter;
    private BusinessAdapter businessAdapter;

    List<TestBean> list = new ArrayList<>();

    @Override
    public View initView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle
            savedInstanceState) {
        rootView = inflater.inflate(R.layout.homepage_main_fragment, container, false);
        return rootView;
    }

    private void initData() {
        showView.setOnRetryListener(this);//设置监听
        if (!isNetworkConnected(getActivity())) {
            showView.setVisibility(View.VISIBLE);
            showView.show(ShowView.NO_NET);
        } else {
            showView.setVisibility(View.GONE);
        }

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        businessAdapter = new BusinessAdapter(R.layout.homepage_main_item, list);
        recyclerView.setAdapter(businessAdapter);
        businessAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ToastUtils.showToast("点击了第" + position + "个");
                //                RouterUtils.goTo(RouterIntent.DISCOVER_DETAIL);
            }
        });

        mAlumniRecommendationBeanList = new ArrayList<>();
        mAlumniRecommendationAdapter = new AlumniRecommendationAdapter(getActivity(), mAlumniRecommendationBeanList);
        alumniRecommendationRv.setLayoutManager(new LinearLayoutManager(getActivity()));//GridLayoutManager(getActivity(), 2
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
        //加载更多
        smartrefresh.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshlayout) {
                refreshlayout.finishLoadMore();
            }
        });
        smartrefresh.finishLoadMore();
    }

    private void loadData() {
        TestBean testBean1 = new TestBean("张三", "CEO", "三生三世有限公司", "上游企业",
                "A股600123", "等发达的法萨芬的", "1小时前");
        TestBean testBean2 = new TestBean("张三", "CEO", "三生三世有限公司", "下游企业",
                "", "测试", "5-18 11:52");
        TestBean testBean3 = new TestBean("张三", "CEO", "", "下游企业",
                "A股600123", "测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试测试", "12:18");
        TestBean testBean4 = new TestBean("张三", "CEO", "三生三世有限公司", "上游企业",
                "", "等发达的法萨芬的", "1小时前");
        list.add(testBean1);
        list.add(testBean2);
        list.add(testBean3);
        list.add(testBean4);
        businessAdapter = new BusinessAdapter(R.layout.homepage_main_item, list);
        recyclerView.setAdapter(businessAdapter);

        HomePageBean homePageBean;
        for (int i = 0; i < 2; i++) {
            homePageBean = new HomePageBean();
            homePageBean.setTitle("item:" + i);
            mHomePageList.add(homePageBean);
        }
        AlumniRecommendationBean alumniRecommendationBean;
        for (int i = 0; i < 4; i++) {
            alumniRecommendationBean = new AlumniRecommendationBean();
            alumniRecommendationBean.setName("卢庆国");
            alumniRecommendationBean.setPosition("董事长兼总经理");
            alumniRecommendationBean.setCompany("黑龙江老村长就业有限公司");
            mAlumniRecommendationBeanList.add(alumniRecommendationBean);
            mAlumniRecommendationAdapter.notifyDataSetChanged();
        }

        List<View> views = new ArrayList<>();
        views.add(View.inflate(getActivity(), R.layout.homepage_layout_guide, null));
        views.add(View.inflate(getActivity(), R.layout.homepage_layout_guide, null));
        views.add(View.inflate(getActivity(), R.layout.homepage_layout_guide, null));
        bannerContent.setData(views);
    }

    @Override
    protected void lazyLoadData() {
        initData();
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

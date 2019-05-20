package com.hlsk.discover.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hlsk.commonsdk.base.BaseLazyLoadFragment;
import com.hlsk.commonsdk.utils.ToastUtils;
import com.hlsk.discover.R;
import com.hlsk.discover.R2;
import com.hlsk.discover.adapter.BusinessAdapter;
import com.hlsk.discover.core.RouterIntent;
import com.hlsk.discover.entity.TestBean;
import com.hlsk.discover.utils.RouterUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * author:gem
 * date:2019/5/17 16:57
 * desc:
 * version:
 */
public class FragmentBusiness extends BaseLazyLoadFragment {

    @BindView(R2.id.discover_frag_business_rv)
    RecyclerView recyclerView;
    @BindView(R2.id.discover_frag_business_sr)
    SmartRefreshLayout smartRefreshLayout;

    BusinessAdapter adapter;
    List<TestBean> list = new ArrayList<>();

    String typeId = "0";     // "0" 全部 1-推荐 2-关注 3-上游 4-下游

    @Override
    protected void lazyLoadData() {
//        typeId = getArguments().getString("typeId", "0");
        initRefresh();
        initDatas();
    }

    /**
     * 初始化数据
     */
    private void initDatas() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);

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
        adapter = new BusinessAdapter(R.layout.discover_item_frag_business, list);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ToastUtils.showToast("点击了第" + position + "个");
                RouterUtils.goTo(RouterIntent.DISCOVER_DETAIL);
            }
        });
    }

    //状态
    public static FragmentBusiness getInstance(String typeId) {
        FragmentBusiness fb = new FragmentBusiness();
        Bundle bundle = new Bundle();
        bundle.putString("typeId", typeId);
        fb.setArguments(bundle);
        return fb;
    }

    private void initRefresh() {
        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                smartRefreshLayout.finishRefresh(3000);
            }
        });
        smartRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                smartRefreshLayout.finishLoadMore(3000);
            }
        });
    }

    @Override
    public View initView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.discover_fragment_business, container, false);
    }
}
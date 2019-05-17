package com.hlsk.discover.test;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hlsk.commonsdk.base.BaseActivity;
import com.hlsk.commonsdk.core.RouterHub;
import com.hlsk.discover.R;
import com.hlsk.discover.R2;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

@Route(path = RouterHub.TEST_LIST_MULTI)
public class TestMultiActivity extends BaseActivity {
    /**
     * 列表
     */
    @BindView(R2.id.discover_test_multi_rv)
    RecyclerView recyclerView;

    @BindView(R2.id.discover_test_multi_sr)
    SmartRefreshLayout smartRefreshLayout;
    List<TestMultiMode> list;

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.discover_activity_test_multi;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        initRefresh();

        initDatas();
    }

    private void initDatas() {
        list = new ArrayList<>();
        TestMultiAdapter adapter = new TestMultiAdapter(list);
        TestMultiMode testMode;
        for (int i = 0; i < 15; i++) {
            testMode = new TestMultiMode();
            if (i % 3 == 0) {
                testMode.setType(1);
            } else {
                testMode.setType(0);
            }
            testMode.setTitle("我是第" + i + "条标题");
            testMode.setContent("第" + i + "条内容");
            list.add(testMode);
        }
        adapter.setNewData(list);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(TestMultiActivity.this, "onclick" + position, 0).show();
            }
        });
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
}

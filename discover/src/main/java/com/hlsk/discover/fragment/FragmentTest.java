package com.hlsk.discover.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hlsk.commonsdk.base.BaseLazyLoadFragment;
import com.hlsk.discover.R;
import com.hlsk.discover.R2;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import butterknife.BindView;

/**
 * author:gem
 * date:2019/5/17 10:17
 * desc:
 * version:
 */
public class FragmentTest extends BaseLazyLoadFragment {
    @BindView(R2.id.discover_tv_test_frag)
    TextView tvTest;
    @BindView(R2.id.discover_frag_test_rv)
    RecyclerView recyclerView;
    @BindView(R2.id.discover_frag_test_sr)
    SmartRefreshLayout smartRefreshLayout;

    @Override
    protected void lazyLoadData() {
        tvTest.setText("test");
        initRefresh();
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
        return inflater.inflate(R.layout.discover_fragment_test, container, false);
    }

}

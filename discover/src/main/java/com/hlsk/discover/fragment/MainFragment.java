package com.hlsk.discover.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.hlsk.commonsdk.base.BaseLazyLoadFragment;
import com.hlsk.commonsdk.core.RouterHub;
import com.hlsk.discover.R;
import com.hlsk.discover.R2;

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

@Route(path = RouterHub.DISCOVER_MAIN_FRAGMENT)
public class MainFragment extends BaseLazyLoadFragment {

    @BindView(R2.id.discover_tv_test)
    TextView tvTest;
    @BindView(R2.id.discover_main_tab_layout)
    TabLayout tabLayout;

    @BindView(R2.id.discover_main_view_pager)
    ViewPager viewPager;

    @Override
    public View initView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.discover_main_fragment, container, false);
    }

    @Override
    protected void lazyLoadData() {
//        tvTest.setText(R.string.discover_app_name);
    }

    @OnClick({R2.id.discover_tv_test, R2.id.discover_tv_test_multi})
    public void onViewClick(View view) {
        if (view.getId() == R.id.discover_tv_test) {
            ARouter.getInstance().build(RouterHub.TEST_LIST).navigation(getActivity());
        } else if (view.getId() == R.id.discover_tv_test_multi) {
            ARouter.getInstance().build(RouterHub.TEST_LIST_MULTI).navigation(getActivity());
        }
    }
}

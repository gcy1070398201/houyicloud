package com.hlsk.discover.fragment;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
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
import com.hlsk.discover.adapter.TabPagerAdapter;
import com.hlsk.discover.core.RouterIntent;
import com.hlsk.discover.utils.RouterUtils;

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

@Route(path = RouterHub.DISCOVER_MAIN_FRAGMENT)
public class MainFragment extends BaseLazyLoadFragment {

    @BindView(R2.id.discover_tv_test)
    TextView tvTest;
    @BindView(R2.id.discover_main_tab_layout)
    TabLayout mTabLayout;

    @BindView(R2.id.discover_main_view_pager)
    ViewPager mViewPager;
    String[] titles = {"全部", "推荐", "关注", "上游", "下游"};
    TabPagerAdapter adapter;
    private View rootView;

    @Override
    public View initView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.discover_main_fragment, container, false);
        return rootView;
    }

    @Override
    protected void lazyLoadData() {
        tvTest.setText(R.string.discover_app_name);
        initDatas();
        initTabView();
    }

    private void initTabView() {
        for (int i = 0; i < adapter.getCount(); i++) {
            //获取tab
            TabLayout.Tab tab = mTabLayout.getTabAt(i);
            //给tab设置自定义布局
            tab.setCustomView(R.layout.discover_tab_item);
            TextView textView = tab.getCustomView().findViewById(R.id.discover_tab_tv);
            //默认选择第一项
            if (i == 0) {
                textView.setSelected(true);
                textView.setTextSize(22);
                textView.setTypeface(Typeface.DEFAULT_BOLD);
            }
            textView.setText(titles[i]);
        }

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                TextView textView = tab.getCustomView().findViewById(R.id.discover_tab_tv);
                textView.setSelected(true);
                textView.setTextSize(22);
                textView.setTypeface(Typeface.DEFAULT_BOLD);
                //关联Viewpager
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                //恢复默认字体大小
                TextView textView = tab.getCustomView().findViewById(R.id.discover_tab_tv);
                textView.setSelected(false);
                textView.setTextSize(12);
                textView.setTypeface(Typeface.DEFAULT);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

    }

    /**
     * 初始化
     */
    private void initDatas() {
        List<Fragment> list = new ArrayList<>();
//        FragmentBusiness test1 = new FragmentBusiness();
//        FragmentBusiness test2 = new FragmentBusiness();
//        FragmentTest test3 = new FragmentTest();
//        FragmentTest test4 = new FragmentTest();
//        FragmentTest test5 = new FragmentTest();
//        list.add(test1);
//        list.add(test2);
//        list.add(test3);
//        list.add(test4);
//        list.add(test5);
        for (int i = 0; i < titles.length; i++) {
            list.add(FragmentBusiness.getInstance(String.valueOf(i)));
        }
        adapter = new TabPagerAdapter(getChildFragmentManager(), list);
//        mViewPager.setOffscreenPageLimit(1);
        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    @OnClick({R2.id.discover_tv_test, R2.id.discover_tv_test_multi, R2.id.discover_main_tab_img})
    public void onViewClick(View view) {
        if (view.getId() == R.id.discover_tv_test) {
            ARouter.getInstance().build(RouterHub.TEST_LIST).navigation(getActivity());
        } else if (view.getId() == R.id.discover_tv_test_multi) {
            ARouter.getInstance().build(RouterHub.TEST_LIST_MULTI).navigation(getActivity());
        } else if (view.getId() == R.id.discover_main_tab_img) {
            RouterUtils.goTo(RouterIntent.DISCOVER_PUBLISH);
        }
    }

}

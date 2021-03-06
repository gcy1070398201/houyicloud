/*
 * Copyright 2018 JessYan
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hlsk.hedpapp.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.hlsk.commonsdk.base.BaseActivity;
import com.hlsk.commonsdk.core.RouterHub;
import com.hlsk.commonservice.connection.service.ConnectionInfoService;
import com.hlsk.commonservice.discover.service.DiscoverInfoService;
import com.hlsk.commonservice.homepage.service.HomPageInfoService;
import com.hlsk.commonservice.mine.service.MineInfoService;
import com.hlsk.hedpapp.R;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.tencent.bugly.Bugly;
import com.tencent.bugly.crashreport.CrashReport;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import q.rorbin.badgeview.Badge;
import q.rorbin.badgeview.QBadgeView;


/**
 * ================================================
 * 宿主 App 的主页
 * ================================================
 */
@Route(path = RouterHub.APP_MAIN_ACTIVITY)
public class MainActivity extends BaseActivity {
    @Autowired(name = RouterHub.HOMEPAGE_INFO_SERVICE)
    HomPageInfoService mHomPageInfoService;
    @Autowired(name = RouterHub.CONNECTION_INFO_SERVICE)
    ConnectionInfoService mConnectionInfoService;
    @Autowired(name = RouterHub.DISCOVER_INFO_SERVICE)
    DiscoverInfoService mDiscoverInfoService;
    @Autowired(name = RouterHub.MINE_INFO_SERVICE)
    MineInfoService mMineInfoService;

    @BindView(R.id.bnve)
    BottomNavigationViewEx bnve;
    @BindView(R.id.vp)
    ViewPager vp;

    Badge qBadgeView ;


    private long mPressedTime;

    private List<Fragment> fragments;
    private VpAdapter adapter;

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_main;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {

        fragments = new ArrayList<>(4);

        fragments.add(getFragMent(RouterHub.HOMEPAGE_MAIN_FRAGMENT));
        fragments.add(getFragMent(RouterHub.DISCOVER_MAIN_FRAGMENT));
        fragments.add(getFragMent(RouterHub.CONNECTION_MAIN_FRAGMENT));
        fragments.add(getFragMent(RouterHub.MINE_MAIN_FRAGMENT));

        // set adapter
        adapter = new VpAdapter(getSupportFragmentManager(), fragments);
        vp.setAdapter(adapter);

        initNavigationView();

        initEvent();

    }

    private void initEvent(){

        bnve.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.i_homepage:
                        vp.setCurrentItem(0,false);
                        break;
                    case R.id.i_connection:
                        if(qBadgeView != null){
                            qBadgeView.hide(true);
                        }
                        vp.setCurrentItem(2,false);
                        break;
                    case R.id.i_discover:
                        vp.setCurrentItem(1,false);
                        break;
                    case R.id.i_mine:
                        vp.setCurrentItem(3,false);
                        break;

                }
                return true;
            }
        });

        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                bnve.setCurrentItem(i);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    private void initNavigationView() {
        bnve.enableAnimation(false);
        bnve.enableShiftingMode(false);
        bnve.enableItemShiftingMode(false);

        // add badge
        qBadgeView = addBadgeAt(2, 1);
    }

    private Badge addBadgeAt(int position, int number) {
        // add badge
        return new QBadgeView(this)
                .setBadgeNumber(number)
                .setGravityOffset(12, 2, true)
                .bindTarget(bnve.getBottomNavigationItemView(position));

    }


    private Fragment getFragMent(String path){
        return (Fragment) ARouter.getInstance().build(path).navigation();
    }

    @Override
    public void onBackPressed() {
        //获取第一次按键时间
        long mNowTime = System.currentTimeMillis();
        //比较两次按键时间差
        if ((mNowTime - mPressedTime) > 2000) {

            Toast.makeText(getApplicationContext(),
                    "再按一次退出", Toast.LENGTH_SHORT).show();
            mPressedTime = mNowTime;
        } else {
            super.onBackPressed();
        }
    }

    /**
     * view pager adapter
     */
    private static class VpAdapter extends FragmentPagerAdapter {
        private List<Fragment> data;

        public VpAdapter(FragmentManager fm, List<Fragment> data) {
            super(fm);
            this.data = data;
        }

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Fragment getItem(int position) {
            return data.get(position);
        }
    }

}

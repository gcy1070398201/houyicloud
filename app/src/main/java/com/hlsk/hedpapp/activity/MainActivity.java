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

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


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


    private long mPressedTime;

    private List<Fragment> fragments;
    private VpAdapter adapter;

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_main;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        ARouter.getInstance().inject(this);
        //这里想展示组件向外提供服务的功能, 模拟下组件向宿主提供一些必要的信息, 这里为了简单就直接返回本地数据不请求网络了

        fragments = new ArrayList<>(4);

        // create music fragment and add it
        Fragment musicFragment = (Fragment) ARouter.getInstance().build(RouterHub.HOMEPAGE_MAIN_FRAGMENT).navigation();
        if(musicFragment == null)
            musicFragment = new Fragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", getString(R.string.home_page));
        musicFragment.setArguments(bundle);

        // create backup fragment and add it

        Fragment backupFragment = (Fragment) ARouter.getInstance().build(RouterHub.CONNECTION_MAIN_FRAGMENT).navigation();
        if(backupFragment == null)
             backupFragment = new Fragment();
        bundle = new Bundle();
        bundle.putString("title", getString(R.string.connection));
        backupFragment.setArguments(bundle);

        Fragment friendsFragment = (Fragment) ARouter.getInstance().build(RouterHub.DISCOVER_MAIN_FRAGMENT).navigation();
        if(friendsFragment == null)
            friendsFragment = new Fragment();
        bundle = new Bundle();
        bundle.putString("title", getString(R.string.discover));
        friendsFragment.setArguments(bundle);

//        Fragment mineFragment = new Fragment();
        Fragment mineFragment = (Fragment) ARouter.getInstance().build(RouterHub.MINE_MAIN_FRAGMENT).navigation();
        if(mineFragment == null)
            mineFragment= new Fragment();
        bundle = new Bundle();
        bundle.putString("title", getString(R.string.mine));
        mineFragment.setArguments(bundle);

        // add to fragments for adapter
        fragments.add(musicFragment);
        fragments.add(backupFragment);
        fragments.add(friendsFragment);
        fragments.add(mineFragment);

        // set adapter
        adapter = new VpAdapter(getSupportFragmentManager(), fragments);
        vp.setAdapter(adapter);

        // binding with ViewPager
        bnve.setupWithViewPager(vp);

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

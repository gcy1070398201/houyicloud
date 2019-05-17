package com.hlsk.discover.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * author:gem
 * date:2019/5/17 10:00
 * desc:
 * version:
 */
public class TabPagerAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> listFragment;

    public TabPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return null;
    }

    @Override
    public int getCount() {
        return listFragment == null ? 0 : listFragment.size();
    }
}

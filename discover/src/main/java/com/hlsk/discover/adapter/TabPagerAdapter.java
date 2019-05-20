package com.hlsk.discover.adapter;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import java.util.List;

/**
 * author:gem
 * date:2019/5/17 10:00
 * desc:
 * version:
 */
public class TabPagerAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> listFragment;
    private FragmentManager fm;

    public TabPagerAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.listFragment = list;
        this.fm = fm;
    }

    @Override
    public Fragment getItem(int position) {
        return listFragment == null ? null : listFragment.get(position);
    }

    @Override
    public int getCount() {
        return listFragment == null ? 0 : listFragment.size();
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        super.destroyItem(container, position, object);
    }
}

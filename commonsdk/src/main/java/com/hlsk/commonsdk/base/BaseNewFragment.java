package com.hlsk.commonsdk.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 首页-专题
 *
 * @author guchenyang
 * @Date 2019/5/15
 * @time 10:52
 */
public abstract class BaseNewFragment extends Fragment {

    private boolean isFirstLoad=false;//是不是第一次标识
    private Unbinder unbinder;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(setViewLayout(),null);
        unbinder=ButterKnife.bind(this,view);

        initView();

        isFirstLoad=true;//防止视图没有被创建 请求网络 更新UI

        if (getUserVisibleHint()){
            //避免页面来回切换 不会调用onLazyLoad 方法
            onLazyLoad();

            isFirstLoad=false;
        }
        return view;
    }
    //布局ID
    protected abstract int setViewLayout();
    //初始化view
    protected abstract void initView();
    //数据加载接口，留给子类实现
    public abstract void onLazyLoad();

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isFirstLoad&&isVisibleToUser){
            onLazyLoad();
            isFirstLoad=false;
        }
    }

    @Override
    public void onDestroyView() {
        if (unbinder!=null){

            unbinder.unbind();
        }
        super.onDestroyView();
        isFirstLoad=false;
    }
}

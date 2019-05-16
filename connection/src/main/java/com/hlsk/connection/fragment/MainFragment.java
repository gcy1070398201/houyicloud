package com.hlsk.connection.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.hlsk.commonsdk.base.BaseLazyLoadFragment;
import com.hlsk.commonsdk.core.RouterHub;
import com.hlsk.connection.R;
import com.hlsk.connection.R2;

import butterknife.BindView;


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

@Route(path = RouterHub.CONNECTION_MAIN_FRAGMENT)
public class MainFragment extends BaseLazyLoadFragment {

    @BindView(R2.id.tv_test)
    TextView tvTest;


    @Override
    public View initView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.connection_main_fragment, container, false);
    }

    @Override
    protected void lazyLoadData() {
        tvTest.setText(R.string.connection_app_name);
    }
}

package com.hlsk.mine.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.hlsk.commonsdk.base.BaseLazyLoadFragment;
import com.hlsk.commonsdk.core.RouterHub;
import com.hlsk.commonsdk.glide.ImageLoader;
import com.hlsk.mine.R;
import com.hlsk.mine.R2;

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

@Route(path = RouterHub.MINE_MAIN_FRAGMENT)
public class MainFragment extends BaseLazyLoadFragment {

    @BindView(R2.id.tv_test)
    TextView tvTest;
    @BindView(R2.id.mini_img)
    ImageView imageView;

    @Override
    public View initView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.mine_main_fragment, container, false);
    }

    @Override
    protected void lazyLoadData() {
        tvTest.setText(R.string.mine_app_name);
        ImageLoader.getImageLoader(getActivity())
                .setRadius(10)
                .loadUrl("http://5b0988e595225.cdn.sohucs.com/images/20171202/a1cc52d5522f48a8a2d6e7426b13f82b.gif",imageView);
    }
    @OnClick({R2.id.tv_test})
    public void onClickView(View view){

        ARouter.getInstance().build(RouterHub.MINE_MAIN_WEBVIEW_ACTIVITY)
                .withString("url","http://www.baidu.com").navigation();
    }
}

package com.hlsk.discover.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.hlsk.commonsdk.base.BaseActivity;
import com.hlsk.commonsdk.utils.ToastUtils;
import com.hlsk.discover.R;
import com.hlsk.discover.R2;
import com.hlsk.discover.core.RouterIntent;
import com.hlsk.discover.entity.TestDetailBean;
import com.lzy.ninegrid.ImageInfo;
import com.lzy.ninegrid.NineGridView;
import com.lzy.ninegrid.preview.NineGridViewClickAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

@Route(path = RouterIntent.DISCOVER_DETAIL)
public class DiscoverDetailActivity extends BaseActivity {
    @BindView(R2.id.discover_detail_tv_name)
    TextView tv_name;
    @BindView(R2.id.discover_detail_tv_company)
    TextView tv_company;
    @BindView(R2.id.discover_detail_tv_type)
    TextView tv_type;   //企业
    @BindView(R2.id.discover_detail_tv_focus)
    TextView tv_focus;
    @BindView(R2.id.discover_detail_tv_title)
    TextView tv_title;
    @BindView(R2.id.discover_detail_tv_content)
    TextView tv_content;
    //    @BindView(R2.id.discover_detail_tv_rv)
//    RecyclerView recyclerView;
    @BindView(R2.id.discover_detail_tv_time)
    TextView tv_time;
    //立即联系
    @BindView(R2.id.discover_detail_btn)
    Button button;

    @BindView(R2.id.discover_detail_grid)
    NineGridView nineGridView;
    NineGridViewClickAdapter gridViewClickAdapter;

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.discover_activity_detail;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        initDatas();
    }

    /**
     * 初始化数据
     */
    private void initDatas() {
        List<String> list = new ArrayList<>();
        list.add("http://img2.imgtn.bdimg.com/it/u=2850936076,2080165544&fm=206&gp=0.jpg");
        list.add("http://img2.imgtn.bdimg.com/it/u=2850936076,2080165544&fm=206&gp=0.jpg");
        list.add("http://img3.imgtn.bdimg.com/it/u=698582197,4250615262&fm=206&gp=0.jpg");
        list.add("");
        list.add("http://img2.imgtn.bdimg.com/it/u=2850936076,2080165544&fm=206&gp=0.jpg");
        list.add("http://img3.imgtn.bdimg.com/it/u=698582197,4250615262&fm=206&gp=0.jpg");
        list.add("http://img2.imgtn.bdimg.com/it/u=2850936076,2080165544&fm=206&gp=0.jpg");
        TestDetailBean detailBean = new TestDetailBean();
        detailBean.setName("张三");
        detailBean.setPost("CEO");
        detailBean.setCompany("哪家公司");
        detailBean.setTitle("这是测试标题");
        detailBean.setContent("这是测试内容这是测试内容这是测试内容这是测试内容这是测试内容这是测试内容" +
                "这是测试内容这是测试内容这是测试内容这是测试内容这是测试内容这是测试内容这是测试内容");
        detailBean.setLable("标签");
        detailBean.setPublicTime("05-10 11:25");
        detailBean.setList(list);
        List<ImageInfo> infoList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            ImageInfo info = new ImageInfo();
            info.setThumbnailUrl(list.get(i));
            info.setBigImageUrl(list.get(i));
            infoList.add(info);
        }
        tv_name.setText(detailBean.getName() + " | " + detailBean.getPost());
        tv_company.setText(detailBean.getCompany());
        tv_content.setText(detailBean.getContent());
        tv_time.setText(detailBean.getPublicTime());
        tv_title.setText(detailBean.getTitle());
        tv_type.setText("上游企业");
        gridViewClickAdapter = new NineGridViewClickAdapter(DiscoverDetailActivity.this, infoList);
        nineGridView.setAdapter(gridViewClickAdapter);
    }

    @OnClick({R2.id.discover_detail_btn})
    public void onViewClick(View view) {
        if (view.getId() == R.id.discover_detail_btn) {
            ToastUtils.showToast("立即联系");
        }
    }
}

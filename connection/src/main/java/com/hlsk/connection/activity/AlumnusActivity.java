package com.hlsk.connection.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hlsk.commonsdk.base.BaseActivity;
import com.hlsk.commonsdk.utils.ToastUtils;
import com.hlsk.connection.R;
import com.hlsk.connection.R2;
import com.hlsk.connection.adapter.AlumnusRecyclerAdapter;
import com.hlsk.connection.mode.ConSideBarMode;
import com.hlsk.connection.util.ConRouterHub;
import com.hlsk.connection.util.ConRouterUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 后E 企业名录
 *
 * @author guchenyang
 * @Date 2019/5/20
 * @time 10:23
 */
@Route(path = ConRouterHub.con_Alumnus_activity)
public class AlumnusActivity extends BaseActivity {
    @BindView(R2.id.public_toolbar_back)
    RelativeLayout conToolbarBack;
    @BindView(R2.id.public_toolbar_title)
    TextView conToolbarTitle;
    @BindView(R2.id.con_alumnus_rc)
    RecyclerView conAlumnusRc;
    @Autowired(name = "type")
    String type;  //type-1 后E校友录，type-2产业联盟
    List<ConSideBarMode> conSideBarModes;
    AlumnusRecyclerAdapter alumnusRecyclerAdapter;
    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.con_alumnus_layout;
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        conAlumnusRc.setLayoutManager(linearLayoutManager);
        if (type.equals("1")){
            conToolbarTitle.setText(R.string.con_str_alumnus);
            conSideBarModes=obtainData();
        }else if (type.equals("2")){
            conToolbarTitle.setText(R.string.con_str_industry);
            conSideBarModes=obtainSideData();
        }
        alumnusRecyclerAdapter=new AlumnusRecyclerAdapter(R.layout.con_item_linear_content,
                conSideBarModes);
        conAlumnusRc.setAdapter(alumnusRecyclerAdapter);
        alumnusRecyclerAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ToastUtils.showToast(conSideBarModes.get(position).getName());
                Bundle bundle=new Bundle();
                bundle.putString("type","1");
                bundle.putString("name",conSideBarModes.get(position).getName());
                ConRouterUtil.go(ConRouterHub.con_AlumnusList_activity,"info",bundle);
            }
        });

    }

    @OnClick({R2.id.public_toolbar_back})
    public void onViewClick(View view) {
        this.finish();
    }

    private List<ConSideBarMode> obtainData() {
        List<ConSideBarMode> list = new ArrayList<>();
        list.add(new ConSideBarMode("后E 1班", false));
        list.add(new ConSideBarMode("后E 2班", false));
        list.add(new ConSideBarMode("后E 3班", false));
        list.add(new ConSideBarMode("后E 4班", false));
        list.add(new ConSideBarMode("后E 5班", false));
        list.add(new ConSideBarMode("后E 6班", false));
        list.add(new ConSideBarMode("后E 7班", false));
        list.add(new ConSideBarMode("后E 8班", false));
        list.add(new ConSideBarMode("后E 9班", false));
        list.add(new ConSideBarMode("后E 10班", false));
        return list;
    }
    private List<ConSideBarMode> obtainSideData() {
        List<ConSideBarMode> list = new ArrayList<>();
        list.add(new ConSideBarMode("农林渔业", false));
        list.add(new ConSideBarMode("采矿与能源", false));
        list.add(new ConSideBarMode("制造业", false));
        list.add(new ConSideBarMode("建筑与房产", false));
        list.add(new ConSideBarMode("销售与物流", false));
        list.add(new ConSideBarMode("IT胡亮网", false));
        return list;
    }
}


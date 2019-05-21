package com.hlsk.connection.adapter;


import android.support.annotation.Nullable;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hlsk.connection.R;
import com.hlsk.connection.mode.ConSideBarMode;

import java.util.List;

public class AlumnusRecyclerAdapter extends BaseQuickAdapter<ConSideBarMode,BaseViewHolder> {


	public AlumnusRecyclerAdapter(int layoutResId, @Nullable List<ConSideBarMode> data) {
		super(layoutResId, data);
	}

	@Override
	protected void convert(BaseViewHolder helper, ConSideBarMode item) {
		TextView textView=helper.getView(R.id.con_tv_enterprise);
		textView.setText(item.getName());
	}
}

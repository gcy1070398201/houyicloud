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
package com.hlsk.connection.service;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.hlsk.commonsdk.core.RouterHub;
import com.hlsk.commonservice.connection.bean.ConnectionInfo;
import com.hlsk.commonservice.connection.service.ConnectionInfoService;
import com.hlsk.connection.R;

/**
 * ================================================
 * 向外提供服务的接口实现类, 在此类中实现一些具有特定功能的方法提供给外部, 即可让一个组件与其他组件或宿主进行交互
 * ================================================
 */
@Route(path = RouterHub.CONNECTION_INFO_SERVICE, name = "人脉信息服务")
public class ConnectionInfoServiceImpl implements ConnectionInfoService {
    private Context mContext;

    @Override
    public ConnectionInfo getInfo() {
        return new ConnectionInfo(mContext.getString(R.string.public_name_connection));
    }

    @Override
    public void init(Context context) {
        mContext = context;
    }
}

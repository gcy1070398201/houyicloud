/*
 * Copyright 2017 JessYan
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
package com.hlsk.commonsdk.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * ================================================

 * ================================================
 */
public abstract class BaseLazyFragment extends BaseFragment  {

    /* 是否已经准备完毕（onCreateView方法已调用完毕 */
    private boolean isPrepared = false;

    /* 是否已经执行过懒加载 */
    private boolean isLazyLoaded = false;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        isPrepared = true;
//        lazyLoad();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        ARouter.getInstance().inject(this);
        lazyLoad();
    }

    private void lazyLoad(){
        if(getUserVisibleHint() && isPrepared && !isLazyLoaded){
            onLazyLoad();
            isLazyLoaded = true;
        }
    }

    @UiThread
    public abstract void onLazyLoad();
}

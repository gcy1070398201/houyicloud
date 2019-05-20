package com.hlsk.discover.utils;

import android.os.Bundle;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * author:gem
 * date:2019/5/20 11:28
 * desc:
 * version:
 */
public class RouterUtils {
    public static void goTo(String path) {
        ARouter.getInstance().build(path).navigation();
    }

    public static void goTo(String path, String key, String value) {
        ARouter.getInstance()
                .build(path)
                .withString(key, value)
                .navigation();
    }

    public static void goTo(String path, String key, Bundle bundle) {
        ARouter.getInstance()
                .build(path)
                .withBundle(key, bundle)
                .navigation();
    }
}

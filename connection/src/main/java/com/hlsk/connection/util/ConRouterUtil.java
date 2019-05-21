package com.hlsk.connection.util;

import android.os.Bundle;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 *  ConRouterUtil 跳转
 * @author guchenyang
 * @Date 2019/5/20
 * @time 11:18
 */
public class ConRouterUtil {

    public static void go(String path){

        ARouter.getInstance().build(path).navigation();
    }

    public static void go(String path,String key,String value){
        ARouter.getInstance()
                .build(path)
                .withString(key,value)
                .navigation();
    }

    public static void go(String path,String key,Bundle bundle){
        ARouter.getInstance()
                .build(path)
                .withBundle(key,bundle)
                .navigation();
    }
}

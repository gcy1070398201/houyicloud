package com.hlsk.commonsdk.utils;

/**
 * 防止快速点击事件工具类
 */
public class NoDoubleClickUtils {
    private static long lastClickTime;
    private final static int SPACE_TIME = 500;
    private final static int INTERVAL_TIME = 2000;

    public static void initLastClickTime() {
        lastClickTime = 0;
    }

    public synchronized static boolean isDoubleClick() {
        long currentTime = System.currentTimeMillis();
        boolean isClick2;
        if (currentTime - lastClickTime >
                SPACE_TIME) {
            isClick2 = false;
        } else {
            isClick2 = true;
        }
        lastClickTime = currentTime;
        return isClick2;
    }

    public synchronized static boolean isRepeatClick() {
        long currentTime = System.currentTimeMillis();
        boolean isClick2;
        if (currentTime - lastClickTime >
                INTERVAL_TIME) {
            isClick2 = false;
        } else {
            isClick2 = true;
        }
        lastClickTime = currentTime;
        return isClick2;
    }

}

package com.hlsk.connection.util;

import com.hlsk.commonsdk.core.RouterHub;

/**
 * 人脉Router配置
 * @author guchenyang
 * @Date 2019/5/20
 * @time 10:46
 */

public interface ConRouterHub extends RouterHub {

    String con_Alumnus_activity = CONNECTION + "/AlumnusActivity";
    String con_AlumnusList_activity = CONNECTION + "/AlumnusListActivity";
    String con_Enterprise_activity = CONNECTION + "/EnterpriseActivity";
}

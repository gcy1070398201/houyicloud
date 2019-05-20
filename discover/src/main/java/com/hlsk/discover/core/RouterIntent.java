package com.hlsk.discover.core;

import com.hlsk.commonsdk.core.RouterHub;

/**
 * author:gem
 * date:2019/5/20 11:19
 * desc:商机
 * version:
 */
public interface RouterIntent extends RouterHub {
    /**
     * 商机详情
     */
    String DISCOVER_DETAIL = DISCOVER + "/DiscoverDetailActivity";
    /**
     * 商机详情
     */
    String DISCOVER_PUBLISH = DISCOVER + "/DiscoverPublishActivity";
}

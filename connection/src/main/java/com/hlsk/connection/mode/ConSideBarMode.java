package com.hlsk.connection.mode;

/**
 * 首页-专题
 *
 * @author guchenyang
 * @Date 2019/5/20
 * @time 14:12
 */
public class ConSideBarMode {
    private String name;
    private boolean isSelect;

    public ConSideBarMode(String name, boolean isSelect) {
        this.name = name;
        this.isSelect = isSelect;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }
}

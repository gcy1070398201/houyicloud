package com.hlsk.discover.test;

/**
 * author:gem
 * date:2019/5/16 15:28
 * desc:
 * version:
 */
public class TestMultiMode {
    private String title;
    private String content;
    private String imageUrl;
    private int type;    //0-只显示title 1都显示

    public TestMultiMode() {

    }

    public TestMultiMode(String title, String content, String imageUrl) {
        this.title = title;
        this.content = content;
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}

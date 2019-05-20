package com.hlsk.homepage.bean;

/**
 * @Author: tianjun
 * @Date 2019/5/17
 * @Time 14:47
 */
public class HomePageBean {
    private String title;
    private String content;
    private String imageUrl;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

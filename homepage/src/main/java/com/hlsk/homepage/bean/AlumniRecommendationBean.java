package com.hlsk.homepage.bean;

/**
 * @Author: tianjun
 * @Date 2019/5/17
 * @Time 16:45
 */
public class AlumniRecommendationBean {
    private String title;
    private String content;
    private String imageUrl;

    public String getTitle() {
        return title;
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

    public void setTitle(String title) {
        this.title = title;
    }
}

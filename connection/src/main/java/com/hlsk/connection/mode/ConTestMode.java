package com.hlsk.connection.mode;

import java.io.Serializable;

/**
 * @author guchenyang
 * @Date 2019/5/17
 * @time 15:01
 */
public class ConTestMode implements Serializable {
    private String title;
    private String content;
    private String imageUrl;

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
}

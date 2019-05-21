package com.hlsk.discover.entity;

import java.util.List;

/**
 * author:gem
 * date:2019/5/21 11:22
 * desc:
 * version:
 */
public class TestDetailBean {
    private String name;
    private String post;
    private String content;
    private String company;
    private String lable;
    private String title;
    private List<String> list;
    private String publicTime;

    public TestDetailBean() {
    }

    public TestDetailBean(String name, String post, String content, String company, String lable, String title, List<String> list, String publicTime) {
        this.name = name;
        this.post = post;
        this.content = content;
        this.company = company;
        this.lable = lable;
        this.title = title;
        this.list = list;
        this.publicTime = publicTime;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLable() {
        return lable;
    }

    public void setLable(String lable) {
        this.lable = lable;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public String getPublicTime() {
        return publicTime;
    }

    public void setPublicTime(String publicTime) {
        this.publicTime = publicTime;
    }
}

package com.hlsk.discover.entity;

/**
 * author:gem
 * date:2019/5/20 10:38
 * desc:
 * version:
 */
public class TestBean {
    private String name;
    private String post;
    private String company;
    private String type;
    private String codes;
    private String content;
    private String times;

    public TestBean(String name, String post, String company, String type, String codes, String content, String times) {
        this.name = name;
        this.post = post;
        this.company = company;
        this.type = type;
        this.codes = codes;
        this.content = content;
        this.times = times;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCodes() {
        return codes;
    }

    public void setCodes(String codes) {
        this.codes = codes;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }
}

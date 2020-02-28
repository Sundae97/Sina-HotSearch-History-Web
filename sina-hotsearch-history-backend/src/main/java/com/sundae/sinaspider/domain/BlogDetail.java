package com.sundae.sinaspider.domain;

import java.util.Date;
import java.util.List;

public class BlogDetail {
    private long id;
    private long userId;
    private String screenName;
    private String userHeadImgUrl;
    private String blogId;
    private String text;
    private List<String> picUrls;
    private int repostsCount;
    private int commentsCount;
    private int attitudesCount;
    private Date time;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public String getUserHeadImgUrl() {
        return userHeadImgUrl;
    }

    public void setUserHeadImgUrl(String userHeadImgUrl) {
        this.userHeadImgUrl = userHeadImgUrl;
    }

    public String getBlogId() {
        return blogId;
    }

    public void setBlogId(String blogId) {
        this.blogId = blogId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<String> getPicUrls() {
        return picUrls;
    }

    public void setPicUrls(List<String> picUrls) {
        this.picUrls = picUrls;
    }

    public int getRepostsCount() {
        return repostsCount;
    }

    public void setRepostsCount(int repostsCount) {
        this.repostsCount = repostsCount;
    }

    public int getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(int commentsCount) {
        this.commentsCount = commentsCount;
    }

    public int getAttitudesCount() {
        return attitudesCount;
    }

    public void setAttitudesCount(int attitudesCount) {
        this.attitudesCount = attitudesCount;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "BlogDetail{" +
                "id=" + id +
                ", userId=" + userId +
                ", screenName='" + screenName + '\'' +
                ", userHeadImgUrl='" + userHeadImgUrl + '\'' +
                ", blogId='" + blogId + '\'' +
                ", text='" + text + '\'' +
                ", picUrls=" + picUrls +
                ", repostsCount=" + repostsCount +
                ", commentsCount=" + commentsCount +
                ", attitudesCount=" + attitudesCount +
                ", time=" + time +
                '}';
    }
}

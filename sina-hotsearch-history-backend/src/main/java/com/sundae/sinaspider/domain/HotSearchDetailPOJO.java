package com.sundae.sinaspider.domain;

import java.util.Date;

public class HotSearchDetailPOJO {
    private long hotsearchDetailId;
    private int rank;
    private String desc;
    private String icon;
    private long hotsearchBlogDetailId;
    private long userId;
    private String screenName;
    private String userHeadImgUrl;
    private String blogId;
    private String text;
    private String picUrlsString;
    private int repostsCount;
    private int commentsCount;
    private int attitudesCount;
    private Date time;

    public long getHotsearchDetailId() {
        return hotsearchDetailId;
    }

    public void setHotsearchDetailId(long hotsearchDetailId) {
        this.hotsearchDetailId = hotsearchDetailId;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public long getHotsearchBlogDetailId() {
        return hotsearchBlogDetailId;
    }

    public void setHotsearchBlogDetailId(long hotsearchBlogDetailId) {
        this.hotsearchBlogDetailId = hotsearchBlogDetailId;
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

    public String getPicUrlsString() {
        return picUrlsString;
    }

    public void setPicUrlsString(String picUrlsString) {
        this.picUrlsString = picUrlsString;
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
        return "HotSearchDetailPOJO{" +
                "hotsearchDetailId=" + hotsearchDetailId +
                ", rank=" + rank +
                ", desc='" + desc + '\'' +
                ", icon='" + icon + '\'' +
                ", hotsearchBlogDetailId=" + hotsearchBlogDetailId +
                ", userId=" + userId +
                ", screenName='" + screenName + '\'' +
                ", userHeadImgUrl='" + userHeadImgUrl + '\'' +
                ", blogId='" + blogId + '\'' +
                ", text='" + text + '\'' +
                ", picUrlsString='" + picUrlsString + '\'' +
                ", repostsCount=" + repostsCount +
                ", commentsCount=" + commentsCount +
                ", attitudesCount=" + attitudesCount +
                ", time=" + time +
                '}';
    }
}

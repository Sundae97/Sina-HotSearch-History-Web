package com.sundae.sinaspider.domain;

import java.util.List;

public class HotSearchDetail {
    private long id;
    private int rank;
    private String desc;
    private String icon;
    private List<BlogDetail> blogDetails;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public List<BlogDetail> getBlogDetails() {
        return blogDetails;
    }

    public void setBlogDetails(List<BlogDetail> blogDetails) {
        this.blogDetails = blogDetails;
    }

    @Override
    public String toString() {
        return "HotSearchDetail{" +
                "id=" + id +
                ", rank=" + rank +
                ", desc='" + desc + '\'' +
                ", icon='" + icon + '\'' +
                ", blogDetails=" + blogDetails +
                '}';
    }
}

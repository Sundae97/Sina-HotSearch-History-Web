package com.sundae.sinaspider.domain;

import java.util.Date;

public class HotSearch {
    private long id;
    private Date time;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "HotSearch{" +
                "id=" + id +
                ", time=" + time +
                '}';
    }
}

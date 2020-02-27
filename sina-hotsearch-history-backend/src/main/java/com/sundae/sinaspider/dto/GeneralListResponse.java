package com.sundae.sinaspider.dto;

public class GeneralListResponse<T> extends GeneralResponse<T>{

    private int size;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}

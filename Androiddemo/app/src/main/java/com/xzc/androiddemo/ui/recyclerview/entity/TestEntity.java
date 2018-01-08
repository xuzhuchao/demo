package com.xzc.androiddemo.ui.recyclerview.entity;

/**
 * Created by Administrator on 2017-03-08.
 */

public class TestEntity {

    private String name;
    private int img;

    public TestEntity(String name, int img) {
        this.name = name;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}

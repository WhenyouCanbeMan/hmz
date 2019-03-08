package com.hmz.administrator.cf.bean;

public class Bean {
    private int img;
    private String name;
    public Bean(int img,String name)
    {
        this.img=img;
        this.name=name;
    }
    public Bean()
    {

    }
    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package com.hmz.administrator.cf.bean;

import java.util.List;

public class serinfo {


    /**
     * uid : 1
     * ucity : 北京
     * uname : 长城
     * jianjie :
     * umax : 30000
     * ustar : 00:00
     * ustop : 24:00
     * upeople : 24000
     * umoney : 180
     * imgs : [0,1,2,3,4]
     */

    private String uid;
    private String ucity;
    private String uname;
    private String jianjie;
    private int umax;
    private String ustar;
    private String ustop;
    private int umoney;
    private List<Integer> imgs;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUcity() {
        return ucity;
    }

    public void setUcity(String ucity) {
        this.ucity = ucity;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getJianjie() {
        return jianjie;
    }

    public void setJianjie(String jianjie) {
        this.jianjie = jianjie;
    }
    public String getUstar() {
        return ustar;
    }

    public void setUstar(String ustar) {
        this.ustar = ustar;
    }

    public String getUstop() {
        return ustop;
    }

    public void setUstop(String ustop) {
        this.ustop = ustop;
    }

    public int getUmax() {
        return umax;
    }

    public void setUmax(int umax) {
        this.umax = umax;
    }

    public int getUmoney() {
        return umoney;
    }

    public void setUmoney(int umoney) {
        this.umoney = umoney;
    }

    public List<Integer> getImgs() {
        return imgs;
    }

    public void setImgs(List<Integer> imgs) {
        this.imgs = imgs;
    }
}

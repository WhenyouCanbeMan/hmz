package com.hmz.administrator.cf.mvp.contract;


import android.content.Context;

import com.hmz.administrator.cf.base.BaseCallBack;
import com.hmz.administrator.cf.bean.serinfo;

import java.util.List;


public interface MainContract {
    interface Model{
        void getAllUserInfo(String sName, BaseCallBack <List<serinfo>> listBaseCallBack);
    }
    interface Presenter{
        void getAllUserInfo(String sName);
    }

}

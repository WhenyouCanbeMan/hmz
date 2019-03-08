package com.hmz.administrator.cf.mvp.presenter;


import android.content.Context;
import android.util.Log;

import com.hmz.administrator.cf.base.BaseCallBack;
import com.hmz.administrator.cf.base.BasePresenter;
import com.hmz.administrator.cf.bean.serinfo;
import com.hmz.administrator.cf.mvp.contract.MainContract;
import com.hmz.administrator.cf.mvp.model.MainModel;
import com.hmz.administrator.cf.mvp.view.MainView;

import java.util.List;

public class MainPresenter extends BasePresenter<MainView> implements MainContract.Presenter
{
    protected MainModel model;
    public MainPresenter()
    {
        model=new MainModel();
    }
    @Override
    public void getAllUserInfo(String sName) {
        Log.i("来了","来了12");
        model.getAllUserInfo(sName, new BaseCallBack <List<serinfo>>() {

            @Override
            public void onSuccess(List<serinfo> data) {
                Log.i("来了P","aaa"+data.toString());
                Log.i("来了","来了21");
                mView.getAllUserInfo(data);
            }

            @Override
            public void onFailure(String msg) {

            }

            @Override
            public void onError() {

            }

            @Override
            public void onComplete() {

            }
        });
    }
}
package com.hmz.administrator.cf.mvp.model;


import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.hmz.administrator.cf.Page.MainActivity_Page_One;
import com.hmz.administrator.cf.base.BaseCallBack;
import com.hmz.administrator.cf.bean.serinfo;
import com.hmz.administrator.cf.config.Api;
import com.hmz.administrator.cf.mvp.contract.MainContract;
import com.hmz.administrator.cf.utils.callback.JsonCallback;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;

import java.util.ArrayList;
import java.util.List;

public class MainModel implements MainContract.Model
{

    @Override
    public void getAllUserInfo(String sName, final BaseCallBack <List<serinfo>> baseCallBack) {
        Log.i("来了","来了1.5");
        OkGo.<List<serinfo>>get(Api.web)
                .execute(new JsonCallback<List<serinfo>>() {
                    @Override
                    public void onSuccess(Response<List<serinfo>> response) {
                        Log.i("来了","来了3");
                        baseCallBack.onSuccess(response.body());
                    }
                });

       /* serinfo serinfo=new serinfo();
        List<serinfo.DataBean> list=new ArrayList<>();
        for(int i=0;i<5;i++)
        {
            serinfo serinfo1=new serinfo();
         }*/
    }
}

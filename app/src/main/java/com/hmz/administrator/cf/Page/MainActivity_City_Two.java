package com.hmz.administrator.cf.Page;

import android.os.Bundle;

import com.hmz.administrator.cf.R;
import com.hmz.administrator.cf.base.BaseMvpActivity;
import com.hmz.administrator.cf.bean.serinfo;
import com.hmz.administrator.cf.mvp.presenter.MainPresenter;
import com.hmz.administrator.cf.mvp.view.MainView;

import java.util.List;

public class MainActivity_City_Two extends BaseMvpActivity<MainPresenter> implements MainView
{
    public void onCreate(Bundle b)
    {
        super.onCreate(b);
    }
    @Override
    public int getLayoutId() {
        return R.layout.activity_main_city_two;
    }

    @Override
    public void initView() {

    }

    @Override
    public void findView() {

    }

    @Override
    public void getAllUserInfo(List<serinfo> list) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onError(Throwable throwable) {

    }
}

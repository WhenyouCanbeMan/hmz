package com.hmz.administrator.cf.Page;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SearchView;

import com.hmz.administrator.cf.R;
import com.hmz.administrator.cf.base.BaseMvpActivity;
import com.hmz.administrator.cf.bean.serinfo;
import com.hmz.administrator.cf.mvp.presenter.MainPresenter;
import com.hmz.administrator.cf.mvp.view.MainView;

import java.util.List;

public class MainActivity_City_One extends BaseMvpActivity<MainPresenter> implements MainView
{
    private SearchView searchView;
    public void onCreate(Bundle b)
    {
        super.onCreate(b);
    }
    @Override
    public int getLayoutId() {
        return R.layout.activity_main_city_one;
    }

    @Override
    public void initView() {
        searchView=findViewById(R.id.searchView);
        searchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(MainActivity_City_One.this,MainActivity_City_Two.class);
                startActivity(in);
                finish();
            }
        });
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

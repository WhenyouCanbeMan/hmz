package com.hmz.administrator.cf.Page.FragmentUser;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.hmz.administrator.cf.R;
import com.hmz.administrator.cf.adapter.newsAdapter;
import com.hmz.administrator.cf.base.BaseMvp;
import com.hmz.administrator.cf.bean.NewsBean;
import com.hmz.administrator.cf.mvp.presenter.Main2Presenter;
import com.hmz.administrator.cf.mvp.view.Main2View;

public class fthreeUser3 extends BaseMvp<Main2Presenter> implements Main2View,AdapterView.OnItemClickListener {

    private newsAdapter adapter;
    private ListView listView;
    private NewsBean list;
    private String a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_fthree_user3;
    }

    @Override
    public void initView() {
        mPresenter=new Main2Presenter();
        mPresenter.attachView(this);
        mPresenter.getSuccess();
    }

    @Override
    public void findView() {
        listView=findViewById(R.id.listview);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent=new Intent(fthreeUser3.this,fthreeUser2.class);
        String a= list.getResult().getData().get(position).getUrl();
        intent.putExtra("img",a);
        startActivity(intent);
        finish();
    }

    @Override
    public void getTrafficSuccess(NewsBean data) {
        Log.i("jakshfkjsf",data.toString());
        this.list=data;
        adapter=new newsAdapter(this,data);
        listView.setAdapter(adapter);
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

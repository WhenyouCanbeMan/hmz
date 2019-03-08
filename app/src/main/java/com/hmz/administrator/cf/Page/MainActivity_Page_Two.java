package com.hmz.administrator.cf.Page;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;


import com.hmz.administrator.cf.R;
import com.hmz.administrator.cf.base.BaseActivity;
import com.hmz.administrator.cf.utils.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

public class MainActivity_Page_Two extends BaseActivity {

    int max;
    private Banner myBanner;
    List<Integer> ImageUrlData;
    int c1,c2,c3,c4;
    TextView t1,t2,t3,t4,t6,t7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main__page__two;
    }

    @Override
    public void initView() {
            goNext();
    }

    @Override
    public void findView() {

    }
    public void rili(View v)
    {
        Intent in=new Intent(MainActivity_Page_Two.this,MeiZuActivity.class);
        in.putExtra("max",max);
        Log.i("aksfklasf", String.valueOf(max));
        startActivity(in);
        finish();
    }
    public void backuserTo(View view)
    {
        Intent in=new Intent(MainActivity_Page_Two.this,MainActivity_Page_One.class);
        startActivity(in);
        finish();
    }
    private void initBanner()
    {
        myBanner=findViewById(R.id.banner);
        ImageUrlData=new ArrayList<>();
        ImageUrlData.add(c1);
        ImageUrlData.add(c2);
        ImageUrlData.add(c3);
        ImageUrlData.add(c4);
        myBanner.setImageLoader(new GlideImageLoader());
        myBanner.setImages(ImageUrlData);
        myBanner.setBannerAnimation(Transformer.Default);
        myBanner.setDelayTime(3000);
        myBanner.isAutoPlay(true);
        myBanner.setIndicatorGravity(BannerConfig.CENTER);
        myBanner.start();

    }

    public void goNext()
    {
        Intent intent=getIntent();
        String a=intent.getStringExtra("uname");
        String b=intent.getStringExtra("jianjie");
        int c=intent.getIntExtra("money",0);
        String c01= String.valueOf(c);
        max=intent.getIntExtra("max",0);
        Log.i("aksfklasf", String.valueOf(max));
        String d=intent.getStringExtra("dizhi");
        String e=intent.getStringExtra("star");
        String f=intent.getStringExtra("stop");
        int [] h=intent.getIntArrayExtra("img");
        c1=h[0];
        c2=h[1];
        c3=h[2];
        c4=h[3];
         t1=findViewById(R.id.Uname);//景点名
         t2=findViewById(R.id.jianjie);//简介
         t3=findViewById(R.id.dizhi);//地址
         t4=findViewById(R.id.money);//票价
         t6=findViewById(R.id.star);//开
         t7=findViewById(R.id.people);

        /*
         *
         * 轮播图
         * */
        initBanner();
        t1.setText(a);
        t2.setText(b);
        t3.setText(d);
        t4.setText(c01);
        t6.setText(e);
        t7.setText(max+"");
    }
   /* public void goNext1()
    {
        max=3000;
        *//*
         *
         * 轮播图
         * *//*
        t1.setText("故宫");
        t2.setText("因服务器缘故无法出现其他景点，此页面只供测试");
        t3.setText("北京");
        t4.setText("230");
        t6.setText("");
        t7.setText(3000+"");
    }*/
}

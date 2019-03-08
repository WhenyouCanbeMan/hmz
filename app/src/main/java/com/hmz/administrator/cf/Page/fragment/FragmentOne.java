package com.hmz.administrator.cf.Page.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.TextView;

import com.hmz.administrator.cf.Page.FragmentUser.foneUser1;
import com.hmz.administrator.cf.Page.FragmentUser.foneUser2;
import com.hmz.administrator.cf.Page.FragmentUser.foneUser3;
import com.hmz.administrator.cf.Page.FragmentUser.foneUser4;
import com.hmz.administrator.cf.Page.FragmentUser.foneUser5;
import com.hmz.administrator.cf.Page.MainActivity_Page_One;
import com.hmz.administrator.cf.R;
import com.hmz.administrator.cf.utils.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.Unbinder;




public class FragmentOne extends Fragment {
    private View view;
    private Unbinder unbinder;
    private Banner myBanner;
    List<Integer> ImageUrlData;
    public static FragmentOne newInstance() {
        FragmentOne fragment = new FragmentOne();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       if(view==null)
       {
           view=inflater.inflate(R.layout.one_fragment,null);
           unbinder=ButterKnife.bind(this,view);
           initBanner();
           initView();
           goListPage();
       }
       return view;
    }
    public void initView()
    {
        /*
         * 点击搜索跳转到下一个页面
         * */
        SearchView searchView=view.findViewById(R.id.searchView);
        searchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getContext(),MainActivity_Page_One.class));
            }
        });
        /*
        * 点击攻略跳转到对应页面
        *
        * */
        TextView textView1=view.findViewById(R.id.l1);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),foneUser1.class));
            }
        });
        /*
         * 点击酒店跳转到对应页面
         *
         * */
        TextView textView2=view.findViewById(R.id.l2);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),foneUser2.class));
            }
        });
        /*
         * 点击购票跳转到对应页面
         *
         * */
        TextView textView3=view.findViewById(R.id.l3);
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),foneUser3.class));
            }
        });
        /*
         * 点击笔记跳转到对应页面
         *
         * */
        TextView textView4=view.findViewById(R.id.l4);

        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),foneUser4.class));
            }
        });
        /*
         * 点击出行跳转到对应页面
         *
         * */
        TextView textView5=view.findViewById(R.id.l5);
        textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),foneUser5.class));
            }
        });

    }
    /*
    * 图片轮播页面
    *
    * */
    private void initBanner()
    {
        myBanner=view.findViewById(R.id.banner);
        ImageUrlData=new ArrayList<>();
        ImageUrlData.add(R.drawable.m12);
        ImageUrlData.add(R.drawable.m4);
        ImageUrlData.add(R.drawable.m6);
        ImageUrlData.add(R.drawable.m3);
        ImageUrlData.add(R.drawable.m9);
        myBanner.setImageLoader(new GlideImageLoader());
        myBanner.setImages(ImageUrlData);

        myBanner.setBannerAnimation(Transformer.Default);
        myBanner.setDelayTime(3000);
        myBanner.isAutoPlay(true);
        myBanner.setIndicatorGravity(BannerConfig.CENTER);
        myBanner.start();

    }
    /*
    * 点击跳转到另一个页面
    *
    * */
    public void goListPage()
    {

    }

}






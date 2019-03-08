package com.hmz.administrator.cf.Page.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.hmz.administrator.cf.Page.FragmentUser.ftwoUser1;
import com.hmz.administrator.cf.Page.FragmentUser.ftwoUser2;
import com.hmz.administrator.cf.Page.FragmentUser.ftwoUser3;
import com.hmz.administrator.cf.Page.FragmentUser.ftwoUser4;
import com.hmz.administrator.cf.R;
import com.hmz.administrator.cf.bean.Bean;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public class FragmentFour extends Fragment {
    private List<Bean> list=new ArrayList<Bean>();
    private View view;
    private Unbinder unbinder;

    public static FragmentFour newInstance() {
        FragmentFour fragment = new FragmentFour();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public FragmentFour() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(view==null)
        {
            view = inflater.inflate(R.layout.forth_fragment, null);
            unbinder=ButterKnife.bind(this,view);
            initView();
        }
        return view;
    }
    public void initView()
    {
        /*
         * 点击我的足迹跳转到对应页面
         *
         * */
        LinearLayout linearLayout =view.findViewById(R.id.t1);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),ftwoUser1.class));

            }
        });
        /*
         * 点击我的收藏跳转到对应页面
         *
         * */
        LinearLayout linearLayout1=view.findViewById(R.id.t2);
        linearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),ftwoUser2.class));
            }
        });
        /*
         * 点击我的历史跳转到对应页面
         *
         * */
        LinearLayout linearLayout2=view.findViewById(R.id.t3);
        linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),ftwoUser3.class));
            }
        });
        /*
         * 点击联系我们跳转到对应页面
         *
         * */
        LinearLayout linearLayout3=view.findViewById(R.id.t4);
        linearLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),ftwoUser4.class));
            }
        });


    }
}

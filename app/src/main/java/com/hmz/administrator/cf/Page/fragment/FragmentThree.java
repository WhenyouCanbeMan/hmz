package com.hmz.administrator.cf.Page.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.hmz.administrator.cf.Page.FragmentUser.fthreeUser1;
import com.hmz.administrator.cf.Page.FragmentUser.fthreeUser3;
import com.hmz.administrator.cf.Page.FragmentUser.userthreeH;
import com.hmz.administrator.cf.Page.FragmentUser.userthreeS;
import com.hmz.administrator.cf.Page.FragmentUser.userthreeW;
import com.hmz.administrator.cf.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public class FragmentThree extends Fragment {
    private View view;
    private Unbinder unbinder;
    ImageButton imageButton1,imageButton2;
    public static FragmentThree newInstance() {
        FragmentThree fragment = new FragmentThree();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public FragmentThree() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(view==null)
        {
            view = inflater.inflate(R.layout.three_fragment, container, false);
            unbinder=ButterKnife.bind(this,view);
            goHistro();
        }
        return view;
    }
    public  void goHistro()
    {
            imageButton1=view.findViewById(R.id.imageView8);
            imageButton2=view.findViewById(R.id.imageView9);
            TextView textView=view.findViewById(R.id.newsGoNext);
            TextView wuda=view.findViewById(R.id.bt_wuda);
            TextView hu=view.findViewById(R.id.bt_hua);
            TextView st=view.findViewById(R.id.bt_shen);
            /*
            * 历史记录
            * （左谈框弹出）
            * */
            imageButton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(new Intent(getContext(),fthreeUser1.class)));
                }
            });
            /*
            * 跳转页面
            *
            * */
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        /*
        *
        * 旅游新闻
        *
        * */
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(new Intent(getContext(),fthreeUser3.class)));
            }
        });
        /*
        *
        * 附近新闻1
        *
        *
        *
        * */
        wuda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                * 武大樱花
                * */
                startActivity(new Intent(new Intent(getContext(),userthreeW.class)));
            }
        });

        /*
        *
        *
        * 附近新闻2
        *
        * */
        hu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            /*
            * 黄鹤楼
            * */
                startActivity(new Intent(new Intent(getContext(),userthreeH.class)));
            }
        });

        /*
         *
         *
         * 附近新闻2
         *
         * */
        st.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                 * 北京大学
                 * */
                startActivity(new Intent(new Intent(getContext(),userthreeS.class)));
            }
        });
    }
}

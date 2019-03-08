package com.hmz.administrator.cf.Page.FragmentUser;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.hmz.administrator.cf.R;
import com.hmz.administrator.cf.Page.fragment.FragmentFour;


public class ftwoUser1 extends AppCompatActivity {

    /*
    * 我的足迹
    *
    *
    * */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tuser1);
       ImageView img_back=findViewById(R.id.imageView33);
        img_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ftwoUser1.this,FragmentFour.class);
                startActivity(intent);
                finish();
            }
        });
    }
}

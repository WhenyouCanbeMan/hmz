package com.hmz.administrator.cf.Page.FragmentUser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hmz.administrator.cf.R;

public class foneUser2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user2);
        /*
        * 酒店
        *
        * */
        findView();
    }
    public  void findView()
    {
        Button button=findViewById(R.id.button6);//添加酒店
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                * 点击后可以添加你喜欢的酒店，并且自动添加入你的历史中。在你评价后你可以选择是否共享
                *
                * */
            }
        });
    }
}

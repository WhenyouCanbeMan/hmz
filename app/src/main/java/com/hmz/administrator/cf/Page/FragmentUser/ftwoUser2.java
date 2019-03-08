package com.hmz.administrator.cf.Page.FragmentUser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.hmz.administrator.cf.R;

public class ftwoUser2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ftwouser2);
        /*
        * 我的收藏
        *
        * */
         findview();
    }
    public void findview()
    {
        EditText e1=findViewById(R.id.e1);
        EditText e2=findViewById(R.id.e2);
        String username=e1.getText().toString();
        String password=e2.getText().toString();
        Button b1=findViewById(R.id.button3);
        Button b5=findViewById(R.id.button5);
        /*
        * 注册
        * */
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}

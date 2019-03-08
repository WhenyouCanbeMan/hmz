package com.hmz.administrator.cf.Page.FragmentUser;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hmz.administrator.cf.R;
import com.hmz.administrator.cf.Page.fragment.FragmentFour;

public class ftwoUser4 extends AppCompatActivity {

    private TextView tsex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ftwouser4);
        findView();
    }
    public void findView()
    {
        ImageView imageView=findViewById(R.id.imageView22);//返回
        TextView t1=findViewById(R.id.textView48);//头像
        TextView t2=findViewById(R.id.textView54);//昵称
        TextView t3=findViewById(R.id.textView55);//性别
         tsex=findViewById(R.id.textView70);
        TextView t4=findViewById(R.id.textView56);//个人介绍
        TextView t5=findViewById(R.id.textView57);//我的手机
        /*
        *返回
        * */
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ftwoUser4.this,FragmentFour.class);
                startActivity(intent);
                finish();
            }
        });
        /*
        * 头像更换
        *
        * */
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        /*
         * 更换昵称
         *
         * */
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        /*
         *
         *性别选择
         * */
        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
        /*
         *
         *个人介绍
         * */
        t4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        /*
         *
         *更换手机号
         * */
        t5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @SuppressLint("ResourceType")
    private void showDialog(){
        final String typeArray[] = new String[]{"男", "女"};

        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.p1);
        builder.setTitle("请选择你的性别");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_single_choice, typeArray);
        builder.setSingleChoiceItems(adapter, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                    switch (which)
                    {
                        case 0:
                           tsex.setText("男");
                            Toast.makeText(ftwoUser4.this, "你选择的时男", Toast.LENGTH_SHORT).show();
                            break;
                        case 1:
                            tsex.setText("女");
                            Toast.makeText(ftwoUser4.this, "你选择的时女", Toast.LENGTH_SHORT).show();
                            break;
                    }
            }
        });
        builder.show();

    }


}

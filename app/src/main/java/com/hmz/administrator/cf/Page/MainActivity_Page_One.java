package com.hmz.administrator.cf.Page;

import android.content.Intent;
import android.icu.text.UnicodeSetSpanner;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.hmz.administrator.cf.R;
import com.hmz.administrator.cf.adapter.CarUserAdapter;
import com.hmz.administrator.cf.base.BaseMvpActivity;
import com.hmz.administrator.cf.bean.serinfo;
import com.hmz.administrator.cf.mvp.presenter.MainPresenter;
import com.hmz.administrator.cf.mvp.view.MainView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity_Page_One extends BaseMvpActivity<MainPresenter> implements MainView ,AdapterView.OnItemClickListener{
    private ArrayList<Integer> imagePath;
    private EditText editText;
    private ListView listView;
    private CarUserAdapter adapter;
    private List<serinfo> data;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
   }
    @Override
    public int getLayoutId() {
        return R.layout.activity_main_page_one;
    }

    @Override
    public void initView() {
        mPresenter=new MainPresenter();
        mPresenter.attachView(this);
        //mPresenter.getAllUserInfo("sds");
    }

    @Override
    public void findView() {
        editText = findViewById(R.id.textView3);
        listView=findViewById(R.id.list_view1);
        button=findViewById(R.id.button4);



        //设置键盘搜索按钮
        editText.setInputType(EditorInfo.TYPE_CLASS_TEXT);
        editText.setImeOptions(EditorInfo.IME_ACTION_SEARCH);
        editText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    if (editText.getText().toString().equals(""))
                    {
                        Toast.makeText(MainActivity_Page_One.this, "请输入你要搜索的景点，或点击跳转进入测试页面", Toast.LENGTH_SHORT).show();
                    }else {
                        mPresenter.getAllUserInfo(editText.getText().toString());
                        new Thread(){
                            @Override
                            public void run() {
                                try {
                                    sleep(5000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                if(data==null){
                                    handler.sendEmptyMessage(0x01);
                                }
                            }
                        }.start();
                    }
                }
                return false;
            }
        });
    }
    /*
    * 搜索
    *
    * */

    public void  search1(){
        Intent intent=new Intent(MainActivity_Page_One.this,MainActivity_Page_Two.class);
        startActivity(intent);
        finish();

    }

    @Override
    public void getAllUserInfo(List<serinfo> list) {
            this.data=list;
            adapter=new CarUserAdapter(this,list);
            Log.i("来了222",adapter.toString());
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(this);
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
/*
*
* listvie文本监听
*
* */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent=new Intent(MainActivity_Page_One.this,MainActivity_Page_Two.class);
        String a=data.get(position).getUname();
        String b=data.get(position).getJianjie();
        int c=data.get(position).getUmoney();
        String d=data.get(position).getUcity();
        String e=data.get(position).getUstar();
        String f=data.get(position).getUstop();
        int [] a2={data.get(position).getImgs().get(1),data.get(position).getImgs().get(2),data.get(position).getImgs().get(3),data.get(position).getImgs().get(4)};
        int g=data.get(position).getUmax();
        Log.i("ahfkskjashfasf",a2.toString());
        intent.putExtra("uname",a );//名字
        intent.putExtra("jianjie",b );//简介
        intent.putExtra("money",c );//票价
        intent.putExtra("dizhi",d );//地址
        intent.putExtra("star",e );//开馆时间
        intent.putExtra("stop",f);//闭馆时间
        intent.putExtra("img",a2);//图片
        intent.putExtra("max",g);//最大载客量
        startActivity(intent);
        finish();

    }

    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 0x01:
                    Toast.makeText(MainActivity_Page_One.this,"服务器连接失败，请点击跳转测试！",Toast.LENGTH_LONG).show();
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int [] a={0x7f0800fd,0x7f0800fe,0x7f0800ff,0x7f0800fc,};
                            Intent intent=new Intent(MainActivity_Page_One.this,MainActivity_Page_Two.class);
                            intent.putExtra("uname","故宫" );//名字
                            intent.putExtra("jianjie","避免无法连接服务器而设置的测试页面" );//简介
                            intent.putExtra("money",320);//票价
                            intent.putExtra("dizhi","北京" );//地址
                            intent.putExtra("star","8:00" );//开馆时间
                            intent.putExtra("stop","18:30");//闭馆时间
                            intent.putExtra("img",a);//图片
                            intent.putExtra("max","25000");//最大载客量
                            startActivity(intent);
                            finish();
                        }
                    });
            }
        }
    };


}

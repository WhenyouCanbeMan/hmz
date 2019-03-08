package com.hmz.administrator.cf.Page.FragmentUser;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.hmz.administrator.cf.R;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.util.Calendar;

public class foneUser3 extends AppCompatActivity {
    Calendar cal;
    int month,day;
    private WebView wView;
    public static final int SHOW_DATA = 0X123;
    private String detail = "";
    String a="https://www.12306.cn/index/";
    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            if(msg.what == SHOW_DATA)
            {
                wView.loadDataWithBaseURL("",detail, "text/html","UTF-8","");
            }
        };
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user3);
        /*
        * 购票，可直接在页面进行购票，与12306购票网相连接
        *
        * */
        findView();
    }
    public void findView()
    {
        EditText e1=findViewById(R.id.et1);//起
        EditText e2=findViewById(R.id.et2);//终
        final TextView t3=findViewById(R.id.time3);
        wView =  findViewById(R.id.webView);//网页

        cal = Calendar.getInstance();
        month =cal.get(Calendar.MONTH)+1;
        day =cal.get(Calendar.DATE);
        Button b1=findViewById(R.id.bt7);//搜素
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                * 点击搜索将e1,e2提交
                *
                * */
                t3.setText(month+"月"+day+"日");
                //wView.getSettings().setDomStorageEnabled(true);
               // GetByHttpClient();
                Intent intent=new Intent(foneUser3.this,foneWeb_user.class);
                startActivity(intent);
                finish();
            }
        });
    }
    private void GetByHttpClient() {
        new Thread()
        {
            public void run()
            {
                try {
                    HttpClient httpClient = new DefaultHttpClient();
                    HttpGet httpGet = new HttpGet(a);
                    HttpResponse httpResponse = httpClient.execute(httpGet);
                    if (httpResponse.getStatusLine().getStatusCode() == 200) {
                        HttpEntity entity = httpResponse.getEntity();
                        detail = EntityUtils.toString(entity, "utf-8");
                        handler.sendEmptyMessage(SHOW_DATA);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            };
        }.start();
    }
}

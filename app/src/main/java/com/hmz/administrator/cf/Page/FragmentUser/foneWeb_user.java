package com.hmz.administrator.cf.Page.FragmentUser;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageButton;

import com.hmz.administrator.cf.R;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class foneWeb_user extends AppCompatActivity {
    private WebView wView;
    public static final int SHOW_DATA = 0X123;
    private String detail = "";
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
        setContentView(R.layout.activity_fone_web_user);
        wView = findViewById(R.id.webView);
        ImageButton textView = findViewById(R.id.goNewsNext);
        wView.getSettings().setDomStorageEnabled(true);
        GetByHttpClient();
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(foneWeb_user.this, foneUser3.class);
                startActivity(intent1);
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
                    HttpGet httpGet = new HttpGet("https://www.12306.cn/index/");
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

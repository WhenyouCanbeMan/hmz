package com.hmz.administrator.cf.Page;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.hmz.administrator.cf.R;
import com.hmz.administrator.cf.utils.MainActivity;

public class MainActivity_Start extends AppCompatActivity {
    private static final long SPLASH_DELAY_MILLIS =3000;//自动跳转时间
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_star);
        // 使用Handler的postDelayed方法，3秒后执行跳转到MainActivity
        new Handler().postDelayed(new Runnable() {
            public void run() {
                goHome();
            }
        }, SPLASH_DELAY_MILLIS);
    }
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    protected void setStatusBar() {
        View der = getWindow().getDecorView();
        der.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        getWindow().setStatusBarColor(Color.TRANSPARENT);
    }
    private void goHome() {

        Intent intent = new Intent(MainActivity_Start.this, MainActivity.class);
        MainActivity_Start.this.startActivity(intent);
        MainActivity_Start.this.finish();
    }

}

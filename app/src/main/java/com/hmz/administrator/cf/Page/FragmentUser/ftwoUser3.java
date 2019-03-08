package com.hmz.administrator.cf.Page.FragmentUser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TabHost;
import android.widget.TextView;


import com.hmz.administrator.cf.R;

import java.util.Calendar;

public class ftwoUser3 extends AppCompatActivity {
        private TabHost tab;
        Calendar cal;
        int year;
        int month;
        int day;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ftwouser3);
        /*
        * 我的历史
        * */
        tab = findViewById(android.R.id.tabhost);
        tab.setup();

        LayoutInflater inflater = LayoutInflater.from(this);
        inflater.inflate(R.layout.activity_ftwouser3_user,tab.getTabContentView());
        inflater.inflate(R.layout.activity_ftwouser3_user2,tab.getTabContentView());
        tab.addTab(tab.newTabSpec("历史").setIndicator("历史").setContent(R.id.p1));
        tab.addTab(tab.newTabSpec("推送").setIndicator("推送").setContent(R.id.p2));
        findView();
    }
    public void findView()
    {
        TextView but=findViewById(R.id.textView92);
        final TextView textView=findViewById(R.id.time1);
        final TextView textView1=findViewById(R.id.time2);
        cal = Calendar.getInstance();
        year = cal.get(Calendar.YEAR);
        month =(cal.get(Calendar.MONTH))+1;
        day =(cal.get(Calendar.DATE));

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(year+"-"+month+"-"+day);
                textView1.setText(year+"-"+month+"-"+(day-3));
            }
        });
    }
}

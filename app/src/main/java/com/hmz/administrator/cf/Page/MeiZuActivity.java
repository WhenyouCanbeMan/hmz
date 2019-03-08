package com.hmz.administrator.cf.Page;


import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.haibin.calendarview.Calendar;
import com.haibin.calendarview.CalendarLayout;
import com.haibin.calendarview.CalendarView;
import com.hmz.administrator.cf.R;
import com.hmz.administrator.cf.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;

public class MeiZuActivity extends BaseActivity implements CalendarView.OnDateSelectedListener, CalendarView.OnYearChangeListener
{

    TextView mTextMonthDay;
    TextView mTextYear;
    TextView mTextLunar;
    TextView mTextCurrentDay;
    CalendarView mCalendarView;
    RelativeLayout mRelativeTool;
    private int mYear;
    CalendarLayout mCalendarLayout;

    private static final long SPLASH_DELAY_MILLIS =1000*60*60*12;//自动跳转时间

    @Override
    public int getLayoutId() {
        return R.layout.activity_meizu;
    }

    @Override
    public void initView() {

        mTextMonthDay = findViewById(R.id.tv_month_day);
        mTextYear =  findViewById(R.id.tv_year);
        mTextLunar = findViewById(R.id.tv_lunar);
        mRelativeTool =  findViewById(R.id.rl_tool);
        mCalendarView = findViewById(R.id.calendarView);
        mTextCurrentDay = findViewById(R.id.tv_current_day);



        mTextMonthDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mCalendarLayout.isExpand()) {
                    mCalendarView.showYearSelectLayout(mYear);
                    return;
                }
                mCalendarView.showYearSelectLayout(mYear);
                mTextLunar.setVisibility(View.GONE);
                mTextYear.setVisibility(View.GONE);
                mTextMonthDay.setText(String.valueOf(mYear));
            }
        });
        findViewById(R.id.fl_current).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCalendarView.scrollToCurrent();
            }
        });
        mCalendarLayout = findViewById(R.id.calendarLayout);
        mCalendarView.setOnDateSelectedListener(this);
        mCalendarView.setOnYearChangeListener(this);
        mTextYear.setText(String.valueOf(mCalendarView.getCurYear()));
        mYear = mCalendarView.getCurYear();
        mTextMonthDay.setText(mCalendarView.getCurMonth() + "月" + mCalendarView.getCurDay() + "日");
        mTextLunar.setText("今日");
        mTextCurrentDay.setText(String.valueOf(mCalendarView.getCurDay()));
    }

    /*
     *
     * 按钮监听
     * */
     /*   public void userChange(View view)
        {

            initData();
        }*/

    public void findView() {
        Intent in=getIntent();
        List<Calendar> schemes = new ArrayList<>();
        int year = mCalendarView.getCurYear();
        int month = mCalendarView.getCurMonth();
        int max=in.getIntExtra("max",0);
        Log.i("wwa", String.valueOf(max));
        /*int[] p=new int[30];*/
        int[] p = new int[0];
        switch (month)
        {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                p=new int[31];
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                p=new int[30];
                break;
            case 2:
                if(((year%4==0)&&(year%100!=0)||(year%400==0)))
                {
                    p=new int[29];
                }
                else
                {
                    p=new int[28];
                }
        }
        for(int i=0;i<p.length;i++)
        {
            Log.i("askjhfkjasf", String.valueOf(p.length));
            p[i]= (int) (max/4+Math.random()*10*300);
            Log.i("aaaaaaaaaa", String.valueOf(p[i]));
        }
        for(int n=0;n<p.length;n++)
        {
            if(p[n]<(max/3))
            {
                schemes.add(getSchemeCalendar(year, month, n+1,0,250,0,"假"));
            }
            else if(p[n]<(max*2/3+200)&&p[n]>=(max/3))
            {
                schemes.add(getSchemeCalendar(year, month, n+1,250,250,66,"假"));
            }
            else
            {
                schemes.add(getSchemeCalendar(year,month,n+1,250,0,0,"假"));
            }
            mCalendarView.setSchemeDate(schemes);
        }


        /*
         *
         * 定时
         *
         * */
        new android.os.Handler().postDelayed
                (new Runnable()
                {
                    public void run() throws  RuntimeException{
                        findView();
                    }
                }, SPLASH_DELAY_MILLIS);
    }
    private Calendar getSchemeCalendar(int year, int month, int day, int color1,int color2,int color3, String text) {
        Calendar calendar = new Calendar();
        calendar.setYear(year);
        calendar.setMonth(month);
        calendar.setDay(day);
        calendar.setSchemeColor(Color.rgb(color1,color2,color3));//如果单独标记颜色、则会使用这个颜色
        calendar.setScheme(text);
        calendar.addScheme(new Calendar.Scheme());
        calendar.addScheme(0xFF008800,"假");
        calendar.addScheme(0xFF008800,"节");
        return calendar;
    }
    @Override
    public void onDateSelected(Calendar calendar, boolean isClick) {
        mTextLunar.setVisibility(View.VISIBLE);
        mTextYear.setVisibility(View.VISIBLE);
        mTextMonthDay.setText(calendar.getMonth() + "月" + calendar.getDay() + "日");
        mTextYear.setText(String.valueOf(calendar.getYear()));
        mTextLunar.setText(calendar.getLunar());
        mYear = calendar.getYear();
    }

    @Override
    public void onYearChange(int year)
    {
        mTextMonthDay.setText(String.valueOf(year));
    }
}

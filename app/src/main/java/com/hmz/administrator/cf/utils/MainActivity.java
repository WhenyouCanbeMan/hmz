package com.hmz.administrator.cf.utils;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.hmz.administrator.cf.R;
import com.hmz.administrator.cf.Page.fragment.FragmentFour;
import com.hmz.administrator.cf.Page.fragment.FragmentOne;
import com.hmz.administrator.cf.Page.fragment.FragmentThree;
import com.hmz.administrator.cf.Page.fragment.FragmentTwo;


public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener {
    private BottomNavigationBar mBottomNavigationBar;
    private FragmentOne mFragmentOne;
    private FragmentTwo mFragmentTwo;
    private FragmentThree mFragmentThree;
    private FragmentFour mFragmentFour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBottomNavigationBar = findViewById(R.id.bottom_navigation_bar);


        mBottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        mBottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        mBottomNavigationBar.setBarBackgroundColor(R.color.blue);
        mBottomNavigationBar.setInActiveColor(R.color.white);
        mBottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.a_page, R.string.home_user1).setActiveColorResource(R.color.green))
                .addItem(new BottomNavigationItem(R.drawable.a_city, R.string.home_user2).setActiveColorResource(R.color.orange))
                .addItem(new BottomNavigationItem(R.drawable.a_hot, R.string.home_user3).setActiveColorResource(R.color.lime))
                .addItem(new BottomNavigationItem(R.drawable.a_pcenter, R.string.home_user4)).setActiveColor(R.color.colorAccent)
                .setFirstSelectedPosition(0)
                .initialise();

        mBottomNavigationBar.setTabSelectedListener(this);
        setDefaultFragment();
    }

    /**
     * set the default fragment
     */
    private void setDefaultFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        mFragmentOne = FragmentOne.newInstance();
        transaction.replace(R.id.tb, mFragmentOne).commit();
    }

    @Override
    public void onTabSelected(int position) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (position) {
            case 0:
                if (mFragmentOne == null) {
                    mFragmentOne=FragmentOne.newInstance();
                }
                transaction.replace(R.id.tb, mFragmentOne);
                break;
            case 1:
                if (mFragmentTwo == null) {
                    mFragmentTwo=FragmentTwo.newInstance();
                }
                transaction.replace(R.id.tb, mFragmentTwo);
                break;
            case 2:
                if (mFragmentThree == null) {
                    mFragmentThree = FragmentThree.newInstance();
                }
                transaction.replace(R.id.tb, mFragmentThree);
                break;
            case 3:
                if (mFragmentFour == null) {
                    mFragmentFour = FragmentFour.newInstance();
                }
                transaction.replace(R.id.tb, mFragmentFour);
                break;
        }
        transaction.commit();

    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }
}

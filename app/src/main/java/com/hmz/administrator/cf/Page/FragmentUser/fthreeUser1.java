package com.hmz.administrator.cf.Page.FragmentUser;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import com.hmz.administrator.cf.R;

public class fthreeUser1 extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fthree_user1);
    }

    @Override
    public void onClick(View v) {

    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        finish();
        return true;
    }
}


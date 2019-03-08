package com.hmz.administrator.cf.Page.FragmentUser;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.hmz.administrator.cf.R;
import com.hmz.administrator.cf.Page.fragment.FragmentOne;


public class foneUser1 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user1);

    }

    public void imggoBack(View view) {
        Intent intent=new Intent(foneUser1.this,FragmentOne.class);
        startActivity(intent);
    }

}

/*
package com.hmz.administrator.cf.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hmz.administrator.cf.R;
import com.hmz.administrator.cf.bean.Bean;

import java.util.List;

public class UserAdapter extends BaseAdapter {
    private Context context;
    private List<Bean> bean;
    public UserAdapter(Context context, List<Bean> bean)
    {
        this.context=context;
        this.bean=bean;
    }
    @Override
    public int getCount() {
        return bean.size();
    }

    @Override
    public Object getItem(int position) {
        return bean.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v=LayoutInflater.from(context).inflate(R.layout.user_forth_listviewfornt,parent,false);
        ImageView imageView7=v.findViewById(R.id.imageView2);
        TextView textView12=v.findViewById(R.id.textView3);
        imageView7.setImageResource(bean.get(position).getImg());
        textView12.setText(bean.get(position).getName());
        return v;
    }
}
*/

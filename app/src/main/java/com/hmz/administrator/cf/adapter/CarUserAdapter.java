package com.hmz.administrator.cf.adapter;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hmz.administrator.cf.R;
import com.hmz.administrator.cf.bean.serinfo;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.BitmapCallback;
import com.lzy.okgo.model.Response;

import java.util.List;

public class CarUserAdapter extends BaseAdapter
{
    private Context context;
    private List<serinfo> list;
    public CarUserAdapter(Context context,List<serinfo> list)
    {
        this.context=context;
        this.list=list;
    }
    @Override
    public int getCount() {
        return list.size();
    }
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @SuppressLint("ResourceType")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.user_activity_main_page_list_user1, parent, false);

        TextView id = view.findViewById(R.id.id);
        TextView name = view.findViewById(R.id.name);
        TextView city = view.findViewById(R.id.city);
        final ImageView img = view.findViewById(R.id.img);
        TextView time=view.findViewById(R.id.timeid);

        Log.i("来了qwedw",list.toString());
        id.setText(list.get(position).getUid());
        name.setText(list.get(position).getUname());
        city.setText(list.get(position).getUcity());
        img.setImageResource(list.get(position).getImgs().get(0));
        time.setText(list.get(position).getUstar()+"-"+list.get(position).getUstop());
        return view;
    }
}
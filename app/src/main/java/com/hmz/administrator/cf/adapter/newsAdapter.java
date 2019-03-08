package com.hmz.administrator.cf.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hmz.administrator.cf.R;
import com.hmz.administrator.cf.bean.NewsBean;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.BitmapCallback;
import com.lzy.okgo.model.Response;

public class newsAdapter extends BaseAdapter
{
        private Context context;
        private NewsBean a;
        public newsAdapter(Context context, NewsBean a)
        {
            this.context=context;
            this.a=a;
        }
    @Override
    public int getCount() {
        return a.getResult().getData().size();
    }

    @Override
    public Object getItem(int position) {
        return a.getResult().getData().get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v=LayoutInflater.from(context).inflate(R.layout.user_newsinfo_user_listinfo,parent,false);
        TextView title=v.findViewById(R.id.textView4);
        TextView author_name=v.findViewById(R.id.textView5);
        final ImageView thumbnail_pic_s=v.findViewById(R.id.imageView);

        title.setText(a.getResult().getData().get(position).getTitle());
        author_name.setText(a.getResult().getData().get(position).getAuthor_name());

        OkGo.<Bitmap>get(a.getResult().getData().get(position).getThumbnail_pic_s())
                .execute(new BitmapCallback() {
                    @Override
                    public void onSuccess(Response<Bitmap> response) {
                        thumbnail_pic_s.setImageBitmap(response.body());
                    }
                });
        return v;
    }
}

package com.example.v04.view1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.v04.R;

import java.util.List;
import java.util.Map;

/**
 * Created by yym on 17/4/13.
 */

public class ListViewAdapter extends BaseAdapter {
    Context context;
    List<? extends Map<String,?>> data;
    int ResourceId;  //item显示的布局文件id
    String[] from;  //从数据的哪个字段
    int[] to;       //到布局文件的哪个控件id

    public ListViewAdapter(Context context, List<? extends Map<String, ?>> data, int resourceId, String[] from, int[] to) {
        this.context = context;
        this.data = data;
        ResourceId = resourceId;
        this.from = from;
        this.to = to;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View currentView = inflater.inflate(ResourceId, null);
        Map item = data.get(i);
        String head = (String) item.get("head");
        final String name = (String) item.get("city");
        String nickname = (String) item.get("nickname");

        ImageView imageView = (ImageView) currentView.findViewById(R.id.iv);
        imageView.setImageResource(Integer.parseInt(head));

        TextView tvName = (TextView) currentView.findViewById(R.id.tvname);
        tvName.setText(name);

        TextView tvNick = (TextView) currentView.findViewById(R.id.tvnick);
        tvNick.setText(nickname);

        return currentView;
    }
}

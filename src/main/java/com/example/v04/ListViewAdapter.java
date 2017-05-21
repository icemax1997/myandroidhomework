package com.example.v04;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;
import java.util.Map;
import com.example.v04.news.*;

/**
 * Created by yym on 17/4/13.
 */

public class ListViewAdapter extends BaseAdapter {
    Context context;
    List<? extends Map<String,?>> data;
    int ResourceId;  //item显示的布局文件id
    String[] from;  //从数据的哪个字段
    int[] to;       //到布局文件的哪个控件id
    private int sum;
    private LinearLayout news,news1, news2, news3, news4, news5, news6;
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

        final LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View currentView = inflater.inflate(ResourceId, null);
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

//        news1 = (LinearLayout) mainView.findViewById(R.id.news1);
//        news2 = (LinearLayout) mainView.findViewById(R.id.news2);
//        news3 = (LinearLayout) mainView.findViewById(R.id.news3);
//        news4 = (LinearLayout) mainView.findViewById(R.id.news4);
//        news5 = (LinearLayout) mainView.findViewById(R.id.news5);
//        news6 = (LinearLayout) mainView.findViewById(R.id.news6);
        TextView read = (TextView) currentView.findViewById(R.id.readme);
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (name) {
                    case "讲座：大学生创业如何打动投资人":
//                        Toast.makeText(context, "文章标题为：" + name, Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(context,news1.class);
                        context.startActivity(intent);
                        break;
                    case "第三届彩虹酷跑活动热力开跑":
                        Intent intent2=new Intent(context,news2.class);
                        context.startActivity(intent2);
                        break;
                    case "杭电E路同行优秀大学生宣讲团":
                        Intent intent3=new Intent(context, com.example.v04.news.news3.class);
                        context.startActivity(intent3);
                        break;
                    case "校企合作建慕课 翻转课堂促改革":
                        Intent intent4=new Intent(context,news4.class);
                        context.startActivity(intent4);
                        break;
                    case "计算机系举行16级专业分流介绍会":
                        Intent intent5=new Intent(context,news5.class);
                        context.startActivity(intent5);
                        break;
                    case "14级学生就业实习动员大会":
                        Intent intent6=new Intent(context,news6.class);
                        context.startActivity(intent6);
                        break;
                }


            }


        });


        return currentView;
    }
}

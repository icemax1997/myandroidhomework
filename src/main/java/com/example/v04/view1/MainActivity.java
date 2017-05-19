package com.example.v04.view1;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.v04.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends Activity {

    List data1= new ArrayList();
    int[] heads = new int[]{R.drawable.qq,R.drawable.qq1,R.drawable.qq2};
    String[] citis = new String[]{"北京","上海","杭州"};
    String[] citynicks = new String[]{"帝都","魔都","天堂"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view1);
        Toast.makeText(MainActivity.this,"view1",Toast.LENGTH_LONG).show();
        //数据
        for(int i=0;i<3;i++){
            Map<String,String> ele = new HashMap<String,String>();
            ele.put("nickname",citynicks[i]);
            ele.put("city",citis[i]);
            ele.put("head",Integer.toString(heads[i]));
            data1.add(ele);
        }

        LinearLayout ll = (LinearLayout) this.findViewById(R.id.view1);
        //组件
        ListView lv = new ListView(this);
        //适配器
        ListAdapter adapter = new ListViewAdapter(this,data1, R.layout.view1_itemlayout
                ,new String[]{"city","nickname","head"},new int[]{R.id.tvname,R.id.tvnick,R.id.iv});
        lv.setAdapter(adapter);
        ll.addView(lv);

    }
}

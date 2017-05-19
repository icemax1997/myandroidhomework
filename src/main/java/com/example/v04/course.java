package com.example.v04;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import com.example.v04.courseUI.AbsGridAdapter;
import com.example.v04.courseUI.MyAdapter;

public class course extends AppCompatActivity {

    private Spinner spinner;

    private GridView detailCource;

    private MyAdapter adapter;

    private String[][] contents;

    private AbsGridAdapter secondAdapter;

    private List<String> dataList;

    private ArrayAdapter<String> spinnerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.course);
        spinner = (Spinner)findViewById(R.id.switchWeek);
        detailCource = (GridView)findViewById(R.id.courceDetail);
        ///////////////第一种方式创建Adapater
//        List<String> list = init();
//        adapter = new MyAdapter(this, list);
//        detailCource.setAdapter(adapter);
        ///////////////第二种方式创建Adapter
        fillStringArray();
        secondAdapter = new AbsGridAdapter(this);
        secondAdapter.setContent(contents, 6, 7);
        detailCource.setAdapter(secondAdapter);
        //////////////创建Spinner数据
        fillDataList();
        spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, dataList);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
    }

//    /**
//     * 准备数据
//     */
//    private List<String> init() {
//        List<String> list = new ArrayList<String>();
//        list.add("");
//        list.add("");
//        list.add("微机原理及应用E203");
//        list.add("面向对象程序设计A309");
//        list.add("数据结构与算法B207");
//        list.add("");
//        list.add("");
//        list.add("微机原理及应用E203");
//        list.add("");
//        list.add("电磁场理论A212");
//        list.add("传感器电子测量A\nC309");
//        list.add("微机原理及应用E203");
//        list.add("");
//        list.add("");
//        list.add("电磁场理论A212");
//        list.add("面向对象程序设计A309");
//        list.add("现代测试技术B211");
//        list.add("");
//        list.add("");
//        list.add("");
//        list.add("");
//        list.add("传感器电子测量A\nC309");
//        list.add("面向对象程序设计A309");
//        list.add("");
//        list.add("");
//        list.add("");
//        list.add("");
//        list.add("");
//        list.add("");
//        list.add("");
//        list.add("");
//        list.add("");
//        list.add("");
//        list.add("");
//        list.add("");
//        list.add("");
//        list.add("");
//        list.add("");
//        list.add("");
//        list.add("");
//        list.add("");
//        list.add("");
//        return list;
//    }

    public void fillStringArray() {
        contents = new String[6][7];
        contents[0][0] = "睡觉\nB211";
        contents[1][0] = "吃饭\nE203";
        contents[2][0] = "打豆豆\nA212";
        contents[3][0] = "洗澡\nC309";
        contents[4][0] = "";
        contents[5][0] = "";
        contents[0][1] = "睡觉\nB211";
        contents[1][1] = "";
        contents[2][1] = "吃饭\nA309";
        contents[3][1] = "吃饭\nA309";
        contents[4][1] = "";
        contents[5][1] = "";
        contents[0][2] = "打豆豆\nE203";
        contents[1][2] = "打豆豆\nA212";
        contents[2][2] = "吃饭\nB211";
        contents[3][2] = "";
        contents[4][2] = "";
        contents[5][2] = "";
        contents[0][3] = "吃饭\nA309";
        contents[1][3] = "洗澡\nC309";
        contents[2][3] = "";
        contents[3][3] = "";
        contents[4][3] = "";
        contents[5][3] = "";
        contents[0][4] = "睡觉\nB211";
        contents[1][4] = "谈恋爱\nE203";
        contents[2][4] = "";
        contents[3][4] = "";
        contents[4][4] = "";
        contents[5][4] = "";
        contents[0][5] = "";
        contents[1][5] = "";
        contents[2][5] = "";
        contents[3][5] = "";
        contents[4][5] = "";
        contents[5][5] = "";
        contents[0][6] = "";
        contents[1][6] = "";
        contents[2][6] = "";
        contents[3][6] = "";
        contents[4][6] = "";
        contents[5][6] = "吃饭";
    }

    public void fillDataList() {
        dataList = new ArrayList<>();
        for(int i = 1; i < 21; i++) {
            dataList.add("第" + i + "周");
        }
    }
}

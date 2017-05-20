package com.example.v04;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class cal extends AppCompatActivity {
    private Button reinit,sum;
    private TextView bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9;
    private EditText result;
    private int[] ax=new int[9];
    private Toast myToast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cal);
        reinit = (Button) findViewById(R.id.reinit);
        sum = (Button) findViewById(R.id.sum);
        result= (EditText) findViewById(R.id.result);
        bt1 = (TextView) findViewById(R.id.bt1);
        bt2 = (TextView) findViewById(R.id.bt2);
        bt3 = (TextView) findViewById(R.id.bt3);
        bt4 = (TextView) findViewById(R.id.bt4);
        bt5 = (TextView) findViewById(R.id.bt5);
        bt6 = (TextView) findViewById(R.id.bt6);
        bt7 = (TextView) findViewById(R.id.bt7);
        bt8 = (TextView) findViewById(R.id.bt8);
        bt9 = (TextView) findViewById(R.id.bt9);
        reinit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < 9; i++) {
                    int item = (int) ((Math.random() * 3) + 1);
                    ax[i] = item;

                }
                final String b1t = String.valueOf(ax[0]);
                final String b2t = String.valueOf(ax[1]);
                final String b3t = String.valueOf(ax[2]);
                final String b4t = String.valueOf(ax[3]);
                final String b5t = String.valueOf(ax[4]);
                final String b6t = String.valueOf(ax[5]);
                final String b7t = String.valueOf(ax[6]);
                final String b8t = String.valueOf(ax[7]);
                final String b9t = String.valueOf(ax[8]);

                bt1.setText(b1t);
                bt2.setText(b2t);
                bt3.setText(b3t);
                bt4.setText(b4t);
                bt5.setText(b5t);
                bt6.setText(b6t);
                bt7.setText(b7t);
                bt8.setText(b8t);
                bt9.setText(b9t);

            }
        });
        sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x = Integer.parseInt(result.getText().toString());
                int sum=0;
                for (int i = 0; i < 9; i++) {
                    sum=ax[i]+sum;
                }
                if (sum==x){
                    //获取LayoutInflater对象，该对象可以将布局文件转换成与之一致的view对象
                    LayoutInflater inflater=getLayoutInflater();
                    //将布局文件转换成相应的View对象
                    View layout=inflater.inflate(R.layout.bingo,(ViewGroup)findViewById(R.id.toast_layout_root));
                    //从layout中按照id查找imageView对象
                    ImageView imageView=(ImageView)layout.findViewById(R.id.bingo);
                    //实例化一个Toast对象
                    Toast toast=new Toast(getApplicationContext());
                    toast.setDuration(Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                    toast.setView(layout);
                    toast.show();
                    new Handler().postDelayed(new Runnable(){
                        public void run() {
                            //execute the task
                            Intent intent=new Intent(cal.this,MainActivity .class);
                            startActivity(intent);
                        }
                    }, 2000);

                }

            }
        });
    }

}

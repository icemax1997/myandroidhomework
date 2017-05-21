package com.example.v04.news;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.v04.R;

public class news1 extends AppCompatActivity {
    private Button next,pre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news1);
        pre= (Button) findViewById(R.id.pre);
        next= (Button) findViewById(R.id.next);
        final Intent nextto=new Intent(news1.this,news2.class);
        pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(news1.this,"已经是第一篇新闻了",Toast.LENGTH_SHORT).show();
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(nextto);
                finish();
            }
        });
    }
}

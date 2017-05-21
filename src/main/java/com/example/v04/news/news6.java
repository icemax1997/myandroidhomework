package com.example.v04.news;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.v04.R;

public class news6 extends AppCompatActivity {
    private Button next,pre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news6);
        pre= (Button) findViewById(R.id.pre);
        next= (Button) findViewById(R.id.next);
        final Intent preto=new Intent(news6.this,news5.class);
        pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(preto);
                finish();
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(news6.this,"已经是最后一篇新闻了",Toast.LENGTH_SHORT).show();
            }
        });
    }
}

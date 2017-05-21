package com.example.v04.news;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.v04.R;

public class news5 extends AppCompatActivity {
    private Button next,pre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news5);
        pre= (Button) findViewById(R.id.pre);
        next= (Button) findViewById(R.id.next);
        final Intent preto=new Intent(news5.this,news4.class);
        final Intent nextto=new Intent(news5.this,news6.class);
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
                startActivity(nextto);
                finish();
            }
        });
    }
}

package com.example.v04;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {
    private TextView user;
    private TextView password;
    private Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        user= (TextView) findViewById(R.id.user);
        password= (TextView) findViewById(R.id.password);
        login= (Button) findViewById(R.id.login);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usertext=user.getText().toString();
                String passwordtext=password.getText().toString();
                if (usertext.equals("admin")&&passwordtext.equals("admin")){
                    Intent intent=new Intent(login.this,MainActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(login.this,"错误",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}

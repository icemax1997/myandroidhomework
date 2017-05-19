package com.example.v04;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;


public class alarm extends AppCompatActivity {
    private Timer mTimer;
    private DatePicker datePicker;
    private TimePicker timePicker;
    private EditText editText;
    private Button button;
    private Calendar localtime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTimer = new Timer();
        setContentView(R.layout.alarm);
        datePicker = (DatePicker) findViewById(R.id.datePicker2);
        timePicker = (TimePicker) findViewById(R.id.timePicker3);
        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button2);
        localtime=Calendar.getInstance();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                    获取设置时间
                 */
                int x = datePicker.getYear();
                int y = datePicker.getMonth() + 1;
                int z = datePicker.getDayOfMonth();
                int b = timePicker.getHour();
                int c = timePicker.getMinute();
                /*
                    获取当地时间
                 */
                int year=localtime.get(Calendar.YEAR);
                int month=localtime.get(Calendar.MONTH)+1;
                int day=localtime.get(Calendar.DAY_OF_MONTH);
                int hour=localtime.get(Calendar.HOUR);
                int minute=localtime.get(Calendar.MINUTE);
                /*
                    计算时间差
                 */
                int yd=x-year;
                int monthd=y-month;
                int dd=z-day;
                int md=c-minute;
                int hd=b-hour;

                AlertDialog.Builder dialog=new AlertDialog.Builder(alarm.this);
                dialog.setTitle("闹钟设定");
                dialog.setMessage("你设置了" + x + "年" + y + "月" + z + "日的闹钟\n" +
                        "将在" +yd+"年"+monthd+"月"+dd+"日"+hd+"小时"+md+"分钟后响起\n"+
                        "*为了便于检测，统一设定为5s后响起*");
                dialog.setCancelable(false);
                dialog.setPositiveButton("好的", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        setTimerTask();

                    }
                });
                dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.show();


            }
        });




    }
    private void setTimerTask() {
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {

                Message message = new Message();
                message.what = 1;
                doActionHandler.sendMessage(message);
            }
        }, 5000);
    }

    /**
     * do some action
     */
    private Handler doActionHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            final String editText_value = editText.getText().toString();
            super.handleMessage(msg);
            int msgId = msg.what;
            switch (msgId) {
                case 1:
                    AlertDialog.Builder dialog=new AlertDialog.Builder(alarm.this);
                    dialog.setTitle("您的闹钟");
                    dialog.setMessage(editText_value);
                    dialog.setCancelable(false);
                    dialog.setPositiveButton("好的", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    dialog.show();
                    break;
                default:
                    break;
            }
        }
    };


}

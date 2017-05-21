package com.example.v04;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.OvershootInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    /*
        *变量定义
        */
    private View test;
    private List<View> viewList;
    private ViewPager pager;
    private PagerTabStrip tab;
    private List<String> titleList;
    private LinearLayout fun, setting, news, news1, news2, news3, news4, news5, news6;
    private ImageView gif;
    private Button contact;
    List data1 = new ArrayList();
    int[] heads = new int[]{R.drawable.qq, R.drawable.qq1, R.drawable.qq2, R.drawable.qq, R.drawable.qq1, R.drawable.qq2};
    String[] citis = new String[]{"讲座：大学生创业如何打动投资人",
            "第三届彩虹酷跑活动热力开跑",
            "杭电E路同行优秀大学生宣讲团",
            "校企合作建慕课 翻转课堂促改革",
            "计算机系举行16级专业分流介绍会",
            "14级学生就业实习动员大会"};
    String[] citynicks = new String[]{"创业教育讲座邀请到银杏谷资本投资合伙人、副总裁王海霖先生，为同学们分享了“大学生创业如何打动投资人”的成功经验。",
            "学院第三届“让奔跑不孤单”The color run彩虹酷跑活动在青山湖校区举行。此次活动由学院团委主办，学院学工部和团委老师参加了活动开幕式。",
            "为进一步发挥榜样示范作用，学工部组建“E路同行”优秀大学生宣讲团于本月17日走进校区进行宣讲活动。宣讲团围绕考研、就业、科技竞赛、成长故事等方面进行事迹分享，营造了良好的学习氛围、激励广大学生奋发向上。",
            "为有效推进课堂教学创新，提升课程教学质量，学院于2016年4月起与上海高顿教育集团合作开发《国际结算》、《成本管理会计》两门慕课课程。",
            "5月11日中午，2016级计算机类专业分流介绍会在明德楼5楼报告厅举行， 近四百名2016级计算机类学生参加了本次介绍会。此次介绍会，由校“十佳教师”、 师德先进个人获得者——叶岩明老师主讲。叶老师首先介绍了计算机专业的发展历程和专业分流的主要原则",
            "5月15日下午，我院招生就业部在下沙校区三教 111教室召开“信息工程学院2014级学生就业实习动员大会”。此次动员会邀请了院党委副书记傅君英老师和全体2014级辅导员作为嘉宾。"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
//        showViewPager();
        fun = (LinearLayout) findViewById(R.id.fun);
        setting = (LinearLayout) findViewById(R.id.setting);
        news = (LinearLayout) findViewById(R.id.view1);
//        news1 = (LinearLayout) findViewById(R.id.news1);
//        news2 = (LinearLayout) findViewById(R.id.news2);
//        news3 = (LinearLayout) findViewById(R.id.news3);
//        news4 = (LinearLayout) findViewById(R.id.news4);
//        news5 = (LinearLayout) findViewById(R.id.news5);
//        news6 = (LinearLayout) findViewById(R.id.news6);
        test=(View)findViewById(R.id.news1);
        gif = (ImageView) findViewById(R.id.gif);
//        news1.setVisibility(View.GONE);
//        news2.setVisibility(View.GONE);
//        news3.setVisibility(View.GONE);
//        news4.setVisibility(View.GONE);
//        news5.setVisibility(View.GONE);
//        news6.setVisibility(View.GONE);
        fun.setVisibility(View.GONE);
        setting.setVisibility(View.GONE);
        //数据
        for (int i = 0; i < 6; i++) {
            Map<String, String> ele = new HashMap<String, String>();
            ele.put("nickname", citynicks[i]);
            ele.put("city", citis[i]);
            ele.put("head", Integer.toString(heads[i]));
            data1.add(ele);
        }

        LinearLayout ll = (LinearLayout) this.findViewById(R.id.view1);
        //组件
        ListView lv = new ListView(this);
        lv.setDividerHeight(0);
        //适配器
        ListAdapter adapter = new ListViewAdapter(this, data1, R.layout.news_itemlayout
                , new String[]{"city", "nickname", "head"}, new int[]{R.id.tvname, R.id.tvnick, R.id.iv});
        lv.setAdapter(adapter);
        ll.addView(lv);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            Intent intent = new Intent(MainActivity.this, personal.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.nav_gallery) {
            Toast.makeText(MainActivity.this, "因网络原因，打开网站稍慢!", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(MainActivity.this, github.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.nav_slideshow) {
            Intent intent = new Intent(MainActivity.this, alarm.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.nav_manage) {
            Intent intent = new Intent(MainActivity.this, course.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.nav_send) {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:15858298995"));
            startActivity(intent);
            return true;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.title_messages:
                    news.setVisibility(View.VISIBLE);
                    setting.setVisibility(View.GONE);
                    fun.setVisibility(View.GONE);
//                    pager.setVisibility(View.VISIBLE);

                    return true;
                case R.id.title_fun:
//                    pager.setVisibility(View.GONE);
                    news.setVisibility(View.GONE);
                    setting.setVisibility(View.GONE);
                    fun.setVisibility(View.VISIBLE);
                    Toast.makeText(MainActivity.this, "点击礼盒有惊喜！", Toast.LENGTH_SHORT).show();
                    gif.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
//                            TranslateAnimation animation = new TranslateAnimation(0, -30, 0, -30);
//                            animation.setInterpolator(new OvershootInterpolator());
//                            animation.setDuration(300);
//                            animation.setRepeatCount(6);
//                            animation.setRepeatMode(Animation.REVERSE);
//                            fun.startAnimation(animation);
                            final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                            progressDialog.setTitle("正在强力拆开...");
                            progressDialog.setMessage("幸运值计算中");
                            progressDialog.setCancelable(false);
                            progressDialog.show();
                            new Handler().postDelayed(new Runnable() {
                                public void run() {
                                    //execute the task
                                    progressDialog.dismiss();
                                    createChallange();
                                }
                            }, 2000);
                        }
                    });


                    return true;
                case R.id.title_personal:
//                    pager.setVisibility(View.GONE);
                    news.setVisibility(View.GONE);
                    fun.setVisibility(View.GONE);
                    setting.setVisibility(View.VISIBLE);
                    contact = (Button) findViewById(R.id.contact);

                    contact.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                            dialog.setTitle("🙂成功提交");
                            dialog.setCancelable(false);
                            dialog.setPositiveButton("好的", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            });

                            dialog.show();

                        }
                    });
                    return true;
            }
            return false;
        }

    };

    private void createChallange() {
        int item = (int) ((Math.random() * 2) + 1);
        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
        switch (item) {
            case 1:
                dialog.setTitle("恭喜你！");//标题
                dialog.setMessage("抽中一道计算题\n（智力题擦肩而过）");//文本内容
                dialog.setPositiveButton("小菜一碟", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(MainActivity.this, cal.class);
                        startActivity(intent);
                    }
                });
                dialog.setNegativeButton("溜了溜了", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "胆小鬼", Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();
                break;
            case 2:
                dialog.setTitle("恭喜你！");//标题
                dialog.setMessage("抽中一道智力题\n（计算题擦肩而过）");//文本内容
                dialog.setPositiveButton("小菜一碟", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "程序员太懒了，这道题还没设置。", Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.setNegativeButton("溜了溜了", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    Toast.makeText(MainActivity.this, "胆小鬼", Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();
                break;

        }

    }


//    private void showViewPager() {
//
//        viewList = new ArrayList<View>();
//        View view1 = View.inflate(this, R.layout.view1, null);
//        View view2 = View.inflate(this, R.layout.view2, null);
//        View view3 = View.inflate(this, R.layout.view3, null);
//        viewList.add(view1);
//        viewList.add(view2);
//        viewList.add(view3);
//        titleList = new ArrayList<String>();
//        titleList.add("校园动态");
//        titleList.add("班级动态");
//        titleList.add("科技动态");
//
//        tab = (PagerTabStrip) findViewById(R.id.tab);
//        tab.setBackgroundColor(Color.WHITE);
//        tab.setDrawFullUnderline(false);
//        tab.setTabIndicatorColor(Color.BLUE);
//
//        MyPagerAdapter adapter = new MyPagerAdapter(viewList, titleList);
//        pager = (ViewPager) findViewById(R.id.pager);
//        pager.setAdapter(adapter);
//
//    }
}

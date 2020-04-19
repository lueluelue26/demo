package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import androidx.viewpager.widget.ViewPager;

import android.content.Intent;

import android.os.Bundle;

import android.widget.*;

import android.view.View;
import android.view.View.OnClickListener;

import java.util.List;
import java.util.ArrayList;

import android.graphics.Color;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;




public class InterceptActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView textview1, textview2; //短信和电话标题
    private ViewPager vp; //viewpager页面
    private SmsFragment oneFragment; //短信内容页面
    private PhoneFragment twoFragment; //电话内容页面
    private List<Fragment> mFragmentList = new ArrayList<Fragment>();
    private FragmentAdapter mFragmentAdapter;

    private ImageButton imagebutton1;
    private Intent intent1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intercept);

        initViews(); //初始化布局

        imagebutton1 = (ImageButton) findViewById(R.id.imageButton_setting);
        imagebutton1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v){
                intent1 = new Intent(InterceptActivity.this, Incpt_Setting_Activity.class);
                startActivity(intent1);
            }

        });

        mFragmentAdapter = new FragmentAdapter(this.getSupportFragmentManager(), mFragmentList);
        vp.setOffscreenPageLimit(2); //ViewPager的缓存为2帧
        vp.setAdapter(mFragmentAdapter);
        vp.setCurrentItem(0); //初始设置ViewPager选中第一帧
        textview1.setTextColor(Color.parseColor("#1ba0e1"));

        //ViewPager的监听事件
        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                /*此方法在页面被选中时调用*/
                changeTextColor(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                /*此方法是在状态改变的时候调用，其中arg0这个参数有三种状态（0，1，2）。
                arg0==1默示正在滑动，
                arg0==2默示滑动完毕了，
                arg0==0默示什么都没做。*/
            }
        });
    }

    /**
     * 初始化布局View
     */
    private void initViews() {

        textview1 = (TextView) findViewById(R.id.textView_sms);
        textview2 = (TextView) findViewById(R.id.textView_phone);

        textview1.setOnClickListener(this);
        textview2.setOnClickListener(this);

        vp = (ViewPager) findViewById(R.id.mainViewPager);
        oneFragment = new SmsFragment();
        twoFragment = new PhoneFragment();
        //给FragmentList添加数据
        mFragmentList.add(oneFragment);
        mFragmentList.add(twoFragment);
    }

    /**
     * 点击头部Text 动态修改ViewPager的内容
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.textView_sms:
                vp.setCurrentItem(0, true);
                break;
            case R.id.textView_phone:
                vp.setCurrentItem(1, true);
                break;
        }
    }

    public class FragmentAdapter extends FragmentPagerAdapter {

        List<Fragment> fragmentList = new ArrayList<Fragment>();

        public FragmentAdapter(FragmentManager fm, List<Fragment> fragmentList) {
            super(fm);
            this.fragmentList = fragmentList;
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

    }

    /**
     * 由ViewPager的滑动修改头部导航Text的颜色
     * @param position
     */
    private void changeTextColor(int position) {
        if (position == 0) {
            textview1.setTextColor(Color.parseColor("#1ba0e1"));
            textview2.setTextColor(Color.parseColor("#000000"));
        } else if (position == 1) {
            textview2.setTextColor(Color.parseColor("#1ba0e1"));
            textview1.setTextColor(Color.parseColor("#000000"));
        }
    }
}

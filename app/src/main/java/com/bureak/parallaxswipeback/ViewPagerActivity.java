package com.bureak.parallaxswipeback;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by 杨永青 on 2015/8/25.
 */
public class ViewPagerActivity
        extends ParallaxSwipeBackActivity
{
    ViewPager mainViewPager;

    TextView textView1;

    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_viewpager);

        mainViewPager = (ViewPager) findViewById(R.id.main_viewpager);
        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);

        setOnListener();
        // 初始化
        init();
    }

    private void setOnListener()
    {
        mainViewPager.setOnPageChangeListener(new MyOnPagerChangeListener());

    }

    /**
     * 初始化
     */
    private void init()
    {
        mainViewPager.setAdapter(new MainViewPagerAdapter(getSupportFragmentManager()));
        mainViewPager.setCurrentItem(0);
        // 设置ViewPager可以缓存两个界面，这样子就不会重复的去加载界面
        mainViewPager.setOffscreenPageLimit(2);
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.textView1:
                mainViewPager.setCurrentItem(0);
                break;
            case R.id.textView2:
                mainViewPager.setCurrentItem(1);
                break;
        }
    }

    /**
     * ViewPager页卡适配器
     */
    public class MainViewPagerAdapter
            extends FragmentPagerAdapter
    {
        private ArrayList<Fragment> mFragments;

        public MainViewPagerAdapter(FragmentManager fm)
        {
            super(fm);
            mFragments = new ArrayList<Fragment>();
            mFragments.add(new FragmentPage1Fragment());
            mFragments.add(new FragmentPage2Fragment());
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position)
        {
            return super.instantiateItem(container, position);
        }

        @Override
        public int getCount()
        {
            return mFragments.size();
        }

        @Override
        public Fragment getItem(int position)
        {
            return mFragments.get(position);
        }
    }

    /**
     * ViewPager页面改变监听
     */
    private class MyOnPagerChangeListener
            implements ViewPager.OnPageChangeListener
    {
        @Override
        public void onPageScrollStateChanged(int arg0)
        {
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2)
        {
        }

        @Override
        public void onPageSelected(int position)
        {
            textView1.setTextColor(getResources().getColor(android.R.color.black));
            textView2.setTextColor(getResources().getColor(android.R.color.black));
            if (position == 0)
            {
                textView1.setTextColor(getResources().getColor(android.R.color.holo_green_light));
            }
            else
            {
                textView2.setTextColor(getResources().getColor(android.R.color.holo_green_light));
            }
        }
    }
}

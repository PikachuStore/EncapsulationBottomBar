package com.example.macpro.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;


import org.bottombar.widget.BottomBarItem;
import org.bottombar.widget.CircleStyle;
import org.bottombar.widget.FragmentTabHost;


public class MainActivity extends AppCompatActivity {

    FragmentTabHost mTabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTabHost = findViewById(R.id.tabHost);

        initTabHost();

        // 动态更新数字提示
        ((BottomBarItem) mTabHost.getTabWidget().getChildTabViewAt(2)).setNoticeNum(50);
    }


    // 初始化导航栏
    private void initTabHost() {

        mTabHost.setup(this, getSupportFragmentManager(), R.id.tabHostContent);

        // 消息                         标识 ，必须不一样
        mTabHost.addTab(mTabHost.newTabSpec("0").setIndicator(
                new BottomBarItem(this,R.drawable.msg_selector,R.color.bottom_bar_selector,"消息",5, CircleStyle.REDSOLID))
                ,BlankFragment.class,null);

        // 通讯
        mTabHost.addTab(mTabHost.newTabSpec("1").setIndicator(
                new BottomBarItem(this,R.drawable.address_book_selector,R.color.bottom_bar_selector,"通讯",8,CircleStyle.WHITESOLID))
                ,BlankFragment.class,null);

        // 应用
        mTabHost.addTab(mTabHost.newTabSpec("2").setIndicator(
                new BottomBarItem(this,R.drawable.application_selector,R.color.bottom_bar_selector,"应用",0,CircleStyle.REDSOLID))
                ,BlankFragment.class,null);

        // 我的
        mTabHost.addTab(mTabHost.newTabSpec("3").setIndicator(
                new BottomBarItem(this,R.drawable.me_selector,R.color.bottom_bar_selector,"我的",0,CircleStyle.REDSOLID))
                ,BlankFragment.class,null);

        mTabHost.getTabWidget().setShowDividers(LinearLayout.SHOW_DIVIDER_NONE);

        mTabHost.setCurrentTab(0);
    }
}

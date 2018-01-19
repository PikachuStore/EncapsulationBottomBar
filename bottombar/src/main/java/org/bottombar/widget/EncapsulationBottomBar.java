package org.bottombar.widget;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import org.bottombar.R;
import org.bottombar.bean.BottomBarEntity;

import java.util.List;

/**
 * Created by macpro on 2018/1/8.
 * <p>
 * EncapsulationBottomBar 底部导航栏控件
 */

public class EncapsulationBottomBar extends LinearLayout {


    // 自定义FragmentTabHost
    private FragmentTabHost mTabHost;
    // 底部导航栏上方的分割线
    private View line;
    // 上下文
    private Context mContext;

    public EncapsulationBottomBar(Context context) {
        this(context, null);
    }

    public EncapsulationBottomBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.bottom_bar, this, true);
        this.line = findViewById(R.id.line);
        this.mTabHost = findViewById(R.id.tabHost);
    }

    /****************填充底部导航栏数据*****************************/

    public void setTabDatas(List<BottomBarEntity> datas) {

        FragmentManager fragmentManager = ((AppCompatActivity) mContext).getSupportFragmentManager();

        mTabHost.setup(mContext, fragmentManager, R.id.tabHostContent);

        for (int i = 0; i < datas.size(); i++) {

            BottomBarEntity bottomBarEntity = datas.get(i);


            BottomBarItem item = bottomBarEntity.getItem();
            Bundle bundle = bottomBarEntity.getBundle();

            mTabHost.addTab(mTabHost.newTabSpec(String.valueOf(i)).setIndicator(item)
                    , bottomBarEntity.getClss(), bundle);
        }

        mTabHost.getTabWidget().setShowDividers(LinearLayout.SHOW_DIVIDER_NONE);

        mTabHost.setCurrentTab(0);
    }

    /****************设置底部导航栏上方分割线颜色，0代表没有*****************************/

    public void setLineColor(int colorResId) {

        if (colorResId == 0)
            line.setVisibility(GONE);
        else {
            line.setVisibility(VISIBLE);
            line.setBackgroundColor(colorResId);
        }
    }


    /****************设置当前选中哪个Tab*****************************/

    public void setCurrentTab(int index) {

        mTabHost.setCurrentTab(index);
    }

    /****************重写Tab点击事件(例：登录拦截)*****************************/

    public void overwriteListener(int index, OnClickListener listener) {

        getTabView(index).setOnClickListener(listener);
    }

    /****************返回TabView*****************************/

    public BottomBarItem getTabView(int index) {

        mTabHost.getTabWidget().setClipChildren(false);

        return (BottomBarItem) mTabHost.getTabWidget().getChildTabViewAt(index);

    }


    /****************设置指定下标的数字提醒*****************************/

    public void setNoticeNum(int index, int num) {

        getTabView(index).setNoticeNum(num);
    }


    public void setNoticeNum(int index, String num) {

        getTabView(index).setNoticeNum(num);
    }


    /****************设置指定下标的数字提醒样式*****************************/

    public void setNoticeStyle(int index, CircleStyle style) {

        getTabView(index).setCircleSytle(style);
    }
}

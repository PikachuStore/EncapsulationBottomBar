package org.bottombar.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.bottombar.R;

/**
 * Created by macpro on 2018/1/6.
 *
 *      底部导航栏 ITEM
 */

public class BottomBarItem extends RelativeLayout{

    private ImageView img;
    private TextView tv;
    private Badge badge;

    // 自选样式(数字提醒 int)
    public BottomBarItem(Context context,int selectorId ,int colorSelectorId , String title ,int notice,CircleStyle circleStyle) {
        this(context, selectorId ,colorSelectorId ,title,circleStyle);
        badge.setBadge_Num_ByInt(notice);
    }


    // 自选样式(数字提醒 string)
    public BottomBarItem(Context context,int selectorId ,int colorSelectorId , String title ,String notice,CircleStyle circleStyle) {
        this(context, selectorId ,colorSelectorId ,title,circleStyle);
        badge.setBadge_Num_ByString(notice);
    }



    // 自选样式(无数字提醒)
    public BottomBarItem(Context context, int selectorId ,int colorSelectorId , String title,CircleStyle circleStyle) {
        super(context);

        // 加载布局
        LayoutInflater.from(context).inflate(R.layout.bottom_bar_item,this,true);
        img = findViewById(R.id.bottom_bar_img);
        tv = findViewById(R.id.bottom_bar_tv);
        badge = findViewById(R.id.badge_badge);

        img.setImageResource(selectorId);
        tv.setTextColor(getResources().getColorStateList(colorSelectorId));
        tv.setText(title);

        switch (circleStyle){

            case REDSOLID:
                badge.setCircleStyle(circleStyle);
                break;
            case WHITESOLID:
                badge.setCircleStyle(circleStyle);
                break;
        }

    }


    public void setNoticeNum(int num){

        badge.setBadge_Num_ByInt(num);
    }


    public void setNoticeNum(String num){
        badge.setBadge_Num_ByString(num);
    }
}

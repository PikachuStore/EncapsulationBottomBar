package org.bottombar.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.bottombar.R;
import org.bottombar.utils.DrawableSelectorUtils;

/**
 * Created by macpro on 2018/1/6.
 *
 *        底部导航栏 ITEM
 *
 *              - 图片、文字、Badge
 */

public class BottomBarItem extends RelativeLayout {

    private ImageView img;
    private TextView tv;
    private Badge badge;


    private BottomBarItem(Context context) {
        super(context);
    }

    /**
     * @param context          上下文对象
     * @param imgResUnSelected 未选中状态时的图片
     * @param imgResSelected   选中状态时的图片
     * @param title            文字描述
     */
    private BottomBarItem(Context context, int imgResUnSelected, int imgResSelected, String title) {
        super(context);


        // 加载布局
        LayoutInflater.from(context).inflate(R.layout.bottom_bar_item, this, true);
        img = findViewById(R.id.bottom_bar_img);
        tv = findViewById(R.id.bottom_bar_tv);
        badge = findViewById(R.id.bottombar_badge);

        img.setImageDrawable(DrawableSelectorUtils.getStateListDrawable(context, imgResUnSelected, imgResSelected));
        tv.setText(title);

        // 默认数字提醒,默认文字颜色
        badge.setCircleStyle(CircleStyle.REDSOLID);
    }


    // 需要自己写文字颜色选择器
    public BottomBarItem(Context context, int imgResUnSelected, int imgResSelected, int colorSelectorId, String title) {
        this(context, imgResUnSelected, imgResSelected, title);
        tv.setTextColor(getResources().getColorStateList(colorSelectorId));
    }

    // 无需自己写文字颜色选择器
    public BottomBarItem(Context context, int imgResUnSelected, int imgResSelected, int textColorUnSelected, int textColorSelected, String title) {
        this(context, imgResUnSelected, imgResSelected, title);
        tv.setTextColor(DrawableSelectorUtils.getStateListColor(textColorUnSelected, textColorSelected));
    }

    // 数字提醒 int
    public BottomBarItem(Context context, int imgResUnSelected, int imgResSelected, int colorSelectorId, String title, int notice, CircleStyle circleStyle) {
        this(context, imgResUnSelected, imgResSelected, colorSelectorId, title);
        badge.setBadge_Num_ByInt(notice);
        switch (circleStyle) {
            case REDSOLID:
                badge.setCircleStyle(circleStyle);
                break;
            case WHITESOLID:
                badge.setCircleStyle(circleStyle);
                break;
        }
    }

    // 数字提醒2 int
    public BottomBarItem(Context context, int imgResUnSelected, int imgResSelected, int textColorUnSelected, int textColorSelected, String title, int notice, CircleStyle circleStyle) {
        this(context, imgResUnSelected, imgResSelected, textColorUnSelected, textColorSelected, title);
        badge.setBadge_Num_ByInt(notice);
        switch (circleStyle) {
            case REDSOLID:
                badge.setCircleStyle(circleStyle);
                break;
            case WHITESOLID:
                badge.setCircleStyle(circleStyle);
                break;
        }
    }

    // 数字提醒 string
    public BottomBarItem(Context context, int imgResUnSelected, int imgResSelected, int colorSelectorId, String title, String notice, CircleStyle circleStyle) {
        this(context, imgResUnSelected, imgResSelected, colorSelectorId, title);
        badge.setBadge_Num_ByString(notice);
        switch (circleStyle) {
            case REDSOLID:
                badge.setCircleStyle(circleStyle);
                break;
            case WHITESOLID:
                badge.setCircleStyle(circleStyle);
                break;
        }
    }

    // 数字提醒2 string
    public BottomBarItem(Context context, int imgResUnSelected, int imgResSelected, int textColorUnSelected, int textColorSelected, String title, String notice, CircleStyle circleStyle) {
        this(context, imgResUnSelected, imgResSelected, textColorUnSelected, textColorSelected, title);
        badge.setBadge_Num_ByString(notice);
        switch (circleStyle) {
            case REDSOLID:
                badge.setCircleStyle(circleStyle);
                break;
            case WHITESOLID:
                badge.setCircleStyle(circleStyle);
                break;
        }
    }


    public void setNoticeNum(int num) {

        badge.setBadge_Num_ByInt(num);
    }


    public void setNoticeNum(String num) {

        badge.setBadge_Num_ByString(num);
    }

    // 设置Badge样式
    public void setCircleSytle(CircleStyle circleStyle) {
        badge.setCircleStyle(circleStyle);
    }

}

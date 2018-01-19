package org.bottombar.utils;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;

/**
 * Created by macpro on 2018/1/8.
 *      选择器工具类
 */

public class DrawableSelectorUtils {


    /**
     * 获取文字颜色状态列表
     */
    public static ColorStateList getStateListColor(int textColorUnSelected, int textColorSelected) {

        int[] colors = new int[]{textColorUnSelected, textColorSelected, textColorUnSelected};

        int[][] states = new int[3][];

        states[0] = new int[]{-android.R.attr.state_selected};

        states[1] = new int[]{android.R.attr.state_selected};

        states[2] = new int[]{};

        return new ColorStateList(states,colors);
    }


    /**
     * 获取图片状态列表
     */
    public static StateListDrawable getStateListDrawable(Context context, int imgResUnSelected, int imgResSelected) {

        StateListDrawable stateListDrawable = new StateListDrawable();

        Drawable unSelected = context.getResources().getDrawable(imgResUnSelected);
        Drawable selected = context.getResources().getDrawable(imgResSelected);

        stateListDrawable.addState(new int[]{android.R.attr.state_selected}, selected);
        stateListDrawable.addState(new int[]{-android.R.attr.state_selected}, unSelected);

        return stateListDrawable;
    }

}

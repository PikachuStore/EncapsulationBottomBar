package org.bottombar.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.bottombar.R;


/**
 * Created by macpro on 2017/12/18.
 */

public class Badge extends RelativeLayout {

    private TextView badge_tv;
    private RelativeLayout layout;


    public Badge(Context context ) {
        this(context,null);
    }

    public Badge(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);


        // 加载布局
        LayoutInflater.from(context).inflate(R.layout.badge,this,true);
        this.badge_tv = findViewById(R.id.badge);
        this.layout = findViewById(R.id.layout_badge);
        this.layout.setVisibility(GONE);

    }


    public void setCircleStyle(CircleStyle style){

        switch (style){

            // 红底白字
            case REDSOLID:
                this.layout.setBackgroundResource(R.drawable.notice1);
                this.badge_tv.setTextColor(getResources().getColor(R.color.badge_white));
                break;
            // 白底红字+描边红
            case WHITESOLID:
                this.layout.setBackgroundResource(R.drawable.notice2);
                this.badge_tv.setTextColor(getResources().getColor(R.color.badge_red));
                break;
        }
    }


    public void  setBadge_Num_ByInt(int num){

        if (num==0){
            this.layout.setVisibility(GONE);
        }else if (num>0&&num<=99){
            this.layout.setVisibility(VISIBLE);
            this.badge_tv.setText(num+"");
        }else if (num>99){
            this.layout.setVisibility(VISIBLE);
            this.badge_tv.setText("99");
        }
    }


    public void  setBadge_Num_ByString(String num){

        if (Integer.parseInt(num)==0){
            this.badge_tv.setVisibility(GONE);
        }else if (Integer.parseInt(num)>0&&Integer.parseInt(num)<=99){
            this.badge_tv.setVisibility(VISIBLE);
            this.badge_tv.setText(num);
        }else if (Integer.parseInt(num)>99){
            this.badge_tv.setVisibility(VISIBLE);
            this.badge_tv.setText("99");
        }
    }


}

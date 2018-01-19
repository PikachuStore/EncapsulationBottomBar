package org.bottombar.bean;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import org.bottombar.widget.BottomBarItem;

/**
 * Created by macpro on 2018/1/8.
 */

public class BottomBarEntity {

    private Class<? extends Fragment> clss;
    private BottomBarItem item;
    private Bundle bundle;


    /**
     *
     * @param clss  Fragment类
     * @param item  底部导航栏item对象
     */
    public BottomBarEntity(Class<? extends Fragment> clss, BottomBarItem item) {
        this.clss = clss;
        this.item = item;
    }

    public BottomBarEntity(Class<? extends Fragment> clss, BottomBarItem item, Bundle bundle) {
        this.clss = clss;
        this.item = item;
        this.bundle = bundle;
    }

    public Class<? extends Fragment> getClss() {
        return clss;
    }

    public void setClss(Class<? extends Fragment> clss) {
        this.clss = clss;
    }

    public BottomBarItem getItem() {
        return item;
    }

    public void setItem(BottomBarItem item) {
        this.item = item;
    }

    public Bundle getBundle() {
        return bundle;
    }

    public void setBundle(Bundle bundle) {
        this.bundle = bundle;
    }
}

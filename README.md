# EncapsulationBottomBar
### 使用步骤：

Step 1.Add it in your root build.gradle at the end of repositories:
```
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```

Step 2. Add the dependency:
```
dependencies {
	compile 'com.github.PikachuStore:EncapsulationBottomBar:1.0.0'
}
```

Step 3.xml:
```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context="com.example.pro.myapplication.MainActivity">

	<!--不要更改此id-->
    <FrameLayout
        android:id="@+id/tabHostContent"
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_weight="1"/>

    <!--导航栏上方的分割线-->
    <View
        android:layout_width="match_parent"
        android:layout_height="0.3dp"
        android:background="#868686"/>

    <!--org.bottombar.widget.FragmentTabHost此fragment不会销毁-->
    <!--android.support.v4.app.FragmentTabHost切换底部按钮fragment会销毁-->
    <org.bottombar.widget.FragmentTabHost
        android:id="@+id/tabHost"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:background="@android:color/white">

        <FrameLayout
            android:layout_width="0dp"
            android:layout_height="0dp"/>

    </org.bottombar.widget.FragmentTabHost>

</LinearLayout>
```

Step 4.在Activity中添加如下代码：
```
// 初始化导航栏
private void initTabHost() {

	mTabHost.setup(this, getSupportFragmentManager(), R.id.tabHostContent);

	// 消息                         标识 ，必须不一样
	mTabHost.addTab(mTabHost.newTabSpec("0").setIndicator(
                new BottomBarItem(this,R.drawable.msg_selector,R.color.bottom_bar_selector,"消息",5, CircleStyle.REDSOLID))
                ,BlankFragment.class,null);

	// 通讯
	// BottomBarItem 参数一：上下文对象  参数二：图片选择器   参数三：文字颜色选择器
	//  参数四：文本内容 参数五：数字提醒(没有传0)   参数六：数字提醒的样式(CircleStyle.REDSOLID-红，WHITESOLID白)
	// BlankFragment.class 此Tab所对应的fragment
	mTabHost.addTab(mTabHost.newTabSpec("1").setIndicator(
                new BottomBarItem(this,R.drawable.address_book_selector,R.color.bottom_bar_selector,"通讯",8,CircleStyle.WHITESOLID))
                ,BlankFragment.class,null);

		...

        mTabHost.getTabWidget().setShowDividers(LinearLayout.SHOW_DIVIDER_NONE);
		
	// 默认选中第一个
	mTabHost.setCurrentTab(0);
}
```

```
// 动态更新数字提示
((BottomBarItem) mTabHost.getTabWidget().getChildTabViewAt(2)).setNoticeNum(50);
```
> 效果
![这里写图片描述](https://raw.githubusercontent.com/PikachuStore/EncapsulationBottomBar/master/Screenshot_2018-01-07-11-55-51.png)
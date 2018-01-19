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
	compile 'com.github.PikachuStore:EncapsulationBottomBar:2.0.0'
}
```

Step 3.xml:
```
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context="com.example.macpro.myapplication.MainActivity">

    <org.bottombar.widget.EncapsulationBottomBar
        android:id="@+id/bottom_bar"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>

</RelativeLayout>
```

Step 4.在Activity中添加如下代码：
```

    // 设置数据即可
    bottomBar.setTabDatas(initDatas());

    private List<BottomBarEntity> initDatas() {

        List<BottomBarEntity> list = new ArrayList<>();


        list.add(new BottomBarEntity(BlankFragment.class,
                new BottomBarItem(this,R.mipmap.msg_normal,R.mipmap.msg_press,
                        R.color.bottom_bar_selector,"消息","100",CircleStyle.WHITESOLID)
        ));

        Bundle bundle = new Bundle();
        bundle.putString("url","http:");

        list.add(new BottomBarEntity(BlankFragment.class,
                new BottomBarItem(this,R.mipmap.communication_normal,R.mipmap.communication_press,
                       Color.RED,Color.BLUE,"通讯",100,CircleStyle.WHITESOLID),bundle
        ));

        ... // 有很多重载方法

        return list;

    }
```

```
// 动态更新底部按钮index位置的数字提示
bottomBar.setNoticeNum(index,int or string);
// 重写index位置的底部按钮点击事件
bottomBar.overwriteListener(index,listener);
... 
```
> 效果

![这里写图片描述](https://raw.githubusercontent.com/PikachuStore/EncapsulationBottomBar/master/Screenshot_2018-01-07-11-55-51.png)

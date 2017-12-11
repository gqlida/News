package com.youworkshop.teslanews.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingActivity;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;
import com.youworkshop.teslanews.R;
import com.youworkshop.teslanews.fragment.HomeFragment;
import com.youworkshop.teslanews.fragment.LeftMenuFragment;

public class HomeActivity extends SlidingFragmentActivity {

    public SlidingMenu slidingMenu;

    @SuppressLint("ResourceAsColor")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        int widthPixels = getResources().getDisplayMetrics().widthPixels;
        slidingMenu = getSlidingMenu();
        setBehindContentView(R.layout.layout_slidingmenu);
        slidingMenu.setBackgroundResource(R.drawable.sliding_bg);
//        slidingMenu.setBackgroundResource(R.color.colorText);
        slidingMenu.setBehindWidth(widthPixels/3);
        slidingMenu.setMode(SlidingMenu.LEFT);
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
        initFragment();
    }

    private void initFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_home,new HomeFragment()).commit();
        LeftMenuFragment leftMenuFragment = new LeftMenuFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_sliding,leftMenuFragment).commit();
    }
}

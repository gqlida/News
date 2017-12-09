package com.youworkshop.teslanews.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingActivity;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;
import com.youworkshop.teslanews.R;

public class HomeActivity extends SlidingActivity {

    @SuppressLint("ResourceAsColor")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        SlidingMenu slidingMenu = getSlidingMenu();
        setBehindContentView(R.layout.layout_slidingmenu);
        slidingMenu.setBackgroundColor(R.color.colorPrimary);
        slidingMenu.setBehindWidth(300);
        slidingMenu.setMode(SlidingMenu.LEFT);
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
    }
}

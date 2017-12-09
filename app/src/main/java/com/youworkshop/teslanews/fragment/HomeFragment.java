package com.youworkshop.teslanews.fragment;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.youworkshop.teslanews.R;
import com.youworkshop.teslanews.activity.HomeActivity;
import com.youworkshop.teslanews.page.FirstFragment;
import com.youworkshop.teslanews.page.GovFragment;
import com.youworkshop.teslanews.page.NewsFragment;
import com.youworkshop.teslanews.page.SettingFragment;
import com.youworkshop.teslanews.page.VideoFragment;

public class HomeFragment extends Fragment {

    private View view;
    private FirstFragment firstFragment;
    private SlidingMenu slidingMenu;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //默认加载第一个fragment
        firstFragment = new FirstFragment();
        FragmentManager childFragmentManager = getChildFragmentManager();
        childFragmentManager.beginTransaction().replace(R.id.ll,firstFragment).commit();
        //slidingMenu
        HomeActivity homeActivity = (HomeActivity) getActivity();
        slidingMenu = homeActivity.getSlidingMenu();

        RadioGroup rgButtons = view.findViewById(R.id.rg_buttons);
        rgButtons.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.tab_home:
                        getChildFragmentManager().beginTransaction().replace(R.id.ll, firstFragment).commit();
                        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
                        break;
                    case R.id.tab_news:
                        NewsFragment newsFragment = new NewsFragment();
                        getChildFragmentManager().beginTransaction().replace(R.id.ll, newsFragment).commit();
                        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
                        break;
                    case R.id.tab_videos:
                        VideoFragment videoFragment = new VideoFragment();
                        getChildFragmentManager().beginTransaction().replace(R.id.ll,videoFragment).commit();
                        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
                        break;
                    case R.id.tab_govs:
                        GovFragment govFragment = new GovFragment();
                        getChildFragmentManager().beginTransaction().replace(R.id.ll,govFragment).commit();
                        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
                        break;
                    case R.id.tab_setting:
                        SettingFragment settingFragment = new SettingFragment();
                        getChildFragmentManager().beginTransaction().replace(R.id.ll,settingFragment).commit();
                        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
                        break;

                }
            }
        });

    }
}

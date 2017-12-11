package com.youworkshop.teslanews.menu;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.viewpagerindicator.TabPageIndicator;
import com.youworkshop.teslanews.R;
import com.youworkshop.teslanews.activity.HomeActivity;
import com.youworkshop.teslanews.base.BaseMenuPage;
import com.youworkshop.teslanews.bean.NewCenterBean;
import com.youworkshop.teslanews.bean.TabNewsBean;

import java.util.ArrayList;

/**
 * 侧滑之新闻模块
 * Created by Tony on 2017/12/10.
 */

public class NewMenuPage extends BaseMenuPage {

    private TabPageIndicator indicator;
    private ViewPager newsPager;
    private NewCenterBean.NewCenterBeanItem newCenterBean;
    private ArrayList<TabNewsBean> newsTabPageList;

    public NewMenuPage(Context context, NewCenterBean.NewCenterBeanItem newCenterBean) {
        super(context);
        this.newCenterBean = newCenterBean;
    }

    @Override
    public View initView() {
        View view = View.inflate(context, R.layout.page_newmenu, null);
        indicator = view.findViewById(R.id.indicator);
        newsPager = view.findViewById(R.id.news_viewpage);
        return view;
    }
    //数据的操作都在这里
    @Override
    public void initData() {
        MyPagerAdapter myPagerAdapter = new MyPagerAdapter();
        newsPager.setAdapter(myPagerAdapter);
        newsPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                SlidingMenu slidingMenu = ((HomeActivity) context).getSlidingMenu();
                if (position == 0){
                    slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
                }else{
                    slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        indicator.setVisibility(View.VISIBLE);
        indicator.setViewPager(newsPager);
//        newsTabPageList = new ArrayList<>();
//        for (int i = 0; i < newsTabPageList.size(); i++) {
//                new
//        }
    }

    private class MyPagerAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return newCenterBean.children.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            TextView textView = new TextView(context);
            textView.setText("viewPager中需要添加的界面内容");
            container.addView(textView);
            return textView;
//            return super.instantiateItem(container, position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
//            super.destroyItem(container, position, object);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return newCenterBean.children.get(position).title;
        }
    }
}

package com.youworkshop.teslanews.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.youworkshop.teslanews.R;

public class GuideActivity extends Activity {

    int[] drawbleIDs;
    private ViewPager vpGuide;
    private LinearLayout dotSUnselected;
    private ImageView dotSelected;
    private Button guideNext;
    //    private ArrayList<ImageView> imageListS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        findViews();
        initData();
        initUI();
        initDot();
    }

    private void initDot() {
        dotSUnselected.removeAllViews();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        for (int i = 0; i < drawbleIDs.length; i++) {
            ImageView imageView = new ImageView(GuideActivity.this);
            imageView.setImageResource(R.drawable.shape_dot_gray);
            layoutParams.setMargins(0,0,20,0);
            dotSUnselected.addView(imageView,layoutParams);
        }
//        dotS.addView();
    }

    private void initUI() {
        vpGuide.setAdapter(new MyPagerAdapter());
        vpGuide.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //postion代表位置  positionOffset代表百分比  positionOffsetPixels移动的像素
                int dotWidth = dotSelected.getMeasuredWidth();
                int moveX = (int) ((dotWidth + 20) * (positionOffset + position));
//                System.out.println("dotwidth::"+dotWidth+"positionOffset::"+positionOffset+"position::"+position);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);
                layoutParams.leftMargin = moveX;
                dotSelected.setLayoutParams(layoutParams);
                if (position == drawbleIDs.length-1){
                    guideNext.setVisibility(View.VISIBLE);
                }else{
                    guideNext.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        guideNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GuideActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void findViews() {
        vpGuide = findViewById(R.id.vp_guide);
        dotSUnselected = findViewById(R.id.ll_dot_unselected);
        dotSelected = findViewById(R.id.iv_dot_selected);
        guideNext = findViewById(R.id.guideNext);
    }

    private void initData() {
        //        imageListS = new ArrayList<>();
//        for (int i = 0; i < drawbleIDs.length; i++) {
//            ImageView imageView = new ImageView(GuideActivity.this);
//            imageView.setImageResource(drawbleIDs[i]);
//            imageListS.add(imageView);
//        }
        drawbleIDs = new int[]{R.drawable.guide_01, R.drawable.guide_02, R.drawable.guide_03};

    }

    class MyPagerAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return drawbleIDs.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView imageView = new ImageView(getApplicationContext());
            imageView.setImageResource(drawbleIDs[position]);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            container.addView(imageView);
            return imageView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}

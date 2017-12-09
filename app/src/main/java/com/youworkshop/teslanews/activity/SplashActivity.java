package com.youworkshop.teslanews.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.VideoView;

import com.youworkshop.teslanews.R;
import com.youworkshop.teslanews.Utils.Constant;
import com.youworkshop.teslanews.Utils.SPUtils;


public class SplashActivity extends Activity {


    private Button btnNext;
    private VideoView videoStart;
    private RelativeLayout.LayoutParams layoutParams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        findViews();
        setClick();
        initView();
        initVideo();
    }

    private void initView() {
        int heightPixels = getResources().getDisplayMetrics().heightPixels;
        int widthPixels = getResources().getDisplayMetrics().widthPixels;
        layoutParams = new RelativeLayout.LayoutParams(widthPixels, heightPixels);
    }

    @SuppressLint("ResourceType")
    private void initVideo() {
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.kr36);
        videoStart.setVideoURI(uri);
        videoStart.setLayoutParams(layoutParams);
        videoStart.start();
        videoStart.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                videoStart.start();
            }
        });
    }

    private void findViews() {
        btnNext = findViewById(R.id.btn_next);
        videoStart = findViewById(R.id.vv_video);
    }

    private void setClick() {
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean guideBoolean = SPUtils.getGuideBoolean(SplashActivity.this, Constant.IS_FIRST, true);
                if (guideBoolean){
                    Intent intent = new Intent(SplashActivity.this, GuideActivity.class);
                    startActivity(intent);
                    finish();
                    SPUtils.saveGuideBoolean(SplashActivity.this,Constant.IS_FIRST,false);
                }else{
                    Intent intent = new Intent(SplashActivity.this, HomeActivity.class);
                    startActivity(intent);
                    finish();
                }

            }
        });
    }


}

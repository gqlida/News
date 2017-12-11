package com.youworkshop.teslanews.page;

import android.text.TextUtils;
import android.view.View;

import com.google.gson.Gson;
import com.youworkshop.teslanews.R;
import com.youworkshop.teslanews.Utils.Constant;
import com.youworkshop.teslanews.Utils.SPUtils;
import com.youworkshop.teslanews.base.BaseFragment;
import com.youworkshop.teslanews.base.BaseMenuPage;
import com.youworkshop.teslanews.bean.EventBusMesInfo;
import com.youworkshop.teslanews.bean.NewCenterBean;
import com.youworkshop.teslanews.menu.IntMenuPage;
import com.youworkshop.teslanews.menu.NewMenuPage;
import com.youworkshop.teslanews.menu.PicMenuPage;
import com.youworkshop.teslanews.menu.TopicMenuPage;
import com.youworkshop.teslanews.net.NetUrl;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Tony on 2017/12/9.
 */

public class NewsFragment extends BaseFragment {

    private NewCenterBean newsInfoBean;
    private ArrayList<BaseMenuPage> menuPageList;

    @Override
    public void initData() {
        tabTitle.setText(R.string.tab_news);
        tabType.setVisibility(View.GONE);
        centerIconText.setText(R.string.text_news);
        //优先加载SP中缓存的json文件
        String newsInfo = SPUtils.getNewsInfo(getActivity(), Constant.CATAGORY, "");
        if (!TextUtils.isEmpty(newsInfo)){
            parseJson(newsInfo);
        }
        getData();
    }
    //接收eventbus
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(EventBusMesInfo event) {
        //一旦收到了发布的事件,则会触发此方法,在此方法中调用switchMenuPage(position)方法
        switchMenuPage(event.position);
    };

    @Override
    public void onStart() {
        EventBus.getDefault().register(this);
        super.onStart();
    }

    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    @Override
    public void initView() {
//        centerIcon.setImageResource(R.drawable.btn_news_selected);
    }

    private void getData() {
        OkHttpClient okhttpClient = new OkHttpClient.Builder()
                .connectTimeout(2, TimeUnit.SECONDS)
                .readTimeout(2,TimeUnit.SECONDS)
                .build();

        Request request = new Request.Builder()
                .get()
                .url(NetUrl.CATEGORY)
                .build();

        okhttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json= response.body().string();
                parseJson(json);
                SPUtils.saveNewsInfo(getActivity(), Constant.CATAGORY,json);
            }
        });
    }

    private void parseJson(String json) {
        Gson gson = new Gson();
        newsInfoBean = gson.fromJson(json, NewCenterBean.class);
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                initMenuPage();
                switchMenuPage(0);
            }
        });
    }
    private void initMenuPage() {
        menuPageList = new ArrayList<>();
        IntMenuPage intMenuPage = new IntMenuPage(getActivity());
        NewMenuPage newMenuPage = new NewMenuPage(getActivity(),newsInfoBean.data.get(0));
        PicMenuPage picMenuPage = new PicMenuPage(getActivity());
        TopicMenuPage topicMenuPage = new TopicMenuPage(getActivity());
        menuPageList.add(newMenuPage);
        menuPageList.add(topicMenuPage);
        menuPageList.add(picMenuPage);
        menuPageList.add(intMenuPage);
    }

    private void switchMenuPage(int position) {
        tabTitle.setText(newsInfoBean.data.get(position).title);
        flNewsFrag.removeAllViews();
        BaseMenuPage baseMenuPage = menuPageList.get(position);
        flNewsFrag.addView(baseMenuPage.view);
        baseMenuPage.initData();
    }


}

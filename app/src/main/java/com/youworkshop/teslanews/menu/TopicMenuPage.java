package com.youworkshop.teslanews.menu;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.youworkshop.teslanews.base.BaseMenuPage;

/**
 * 侧滑之话题模块
 * Created by Tony on 2017/12/10.
 */

public class TopicMenuPage extends BaseMenuPage {

    public TopicMenuPage(Context context) {
        super(context);
    }

    @Override
    public View initView() {
        TextView textView = new TextView(context);
        textView.setText("This is TopicMenuPage");
        return textView;
    }

    @Override
    public void initData() {

    }
}

package com.youworkshop.teslanews.menu;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.youworkshop.teslanews.base.BaseMenuPage;

/**
 * 侧滑之互动模块
 * Created by Tony on 2017/12/10.
 */

public class IntMenuPage extends BaseMenuPage {

    public IntMenuPage(Context context) {
        super(context);
    }

    @Override
    public View initView() {
        TextView textView = new TextView(context);
        textView.setText("This is IntMenuPage");
        return textView;
    }

    @Override
    public void initData() {

    }
}

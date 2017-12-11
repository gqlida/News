package com.youworkshop.teslanews.menu;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.youworkshop.teslanews.base.BaseMenuPage;

/**
 * 侧滑之组图模块
 * Created by Tony on 2017/12/10.
 */

public class PicMenuPage extends BaseMenuPage {
    public PicMenuPage(Context context) {
        super(context);
    }

    @Override
    public View initView() {
        TextView textView = new TextView(context);
        textView.setText("This is PicMenuPage");
        return textView;
    }

    @Override
    public void initData() {

    }
}

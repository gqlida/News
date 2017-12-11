package com.youworkshop.teslanews.base;

import android.content.Context;
import android.view.View;

import com.youworkshop.teslanews.Utils.Constant;

/**
 * Created by Tony on 2017/12/10.
 */

public abstract class BaseMenuPage {
    public Context context;
    public View view;

    public BaseMenuPage(Context context){
        this.context = context;
        view = initView();
    }

    public abstract View initView();

    public abstract void initData();
}

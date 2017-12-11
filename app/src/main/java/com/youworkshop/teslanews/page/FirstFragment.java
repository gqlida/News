package com.youworkshop.teslanews.page;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.youworkshop.teslanews.R;
import com.youworkshop.teslanews.base.BaseFragment;

/**
 * Created by Tony on 2017/12/9.
 */

public class FirstFragment extends BaseFragment {

    @Override
    public void initData() {
        tabSliding.setVisibility(View.GONE);
        tabType.setVisibility(View.GONE);
        tabTitle.setText(R.string.tab_home);
        centerIconText.setText(R.string.text_home);
    }

    @Override
    public void initView() {
//        centerIcon.setImageResource(R.drawable.btn_home_selected);
    }
}

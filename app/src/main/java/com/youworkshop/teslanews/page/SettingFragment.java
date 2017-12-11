package com.youworkshop.teslanews.page;

import android.view.View;

import com.youworkshop.teslanews.R;
import com.youworkshop.teslanews.base.BaseFragment;

/**
 * Created by Tony on 2017/12/9.
 */

public class SettingFragment extends BaseFragment {
    @Override
    public void initData() {
        tabSliding.setVisibility(View.GONE);
        tabType.setVisibility(View.GONE);
        tabTitle.setText(R.string.tab_setting);
        centerIconText.setText(R.string.text_setting);
    }

    @Override
    public void initView() {
//        centerIcon.setImageResource(R.drawable.btn_setting_selected);
    }
}

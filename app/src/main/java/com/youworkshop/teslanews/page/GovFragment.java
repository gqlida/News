package com.youworkshop.teslanews.page;

import android.view.View;

import com.youworkshop.teslanews.R;
import com.youworkshop.teslanews.base.BaseFragment;

/**
 * Created by Tony on 2017/12/9.
 */

public class GovFragment extends BaseFragment {

    @Override
    public void initData() {
        tabTitle.setText(R.string.tab_gov);
        centerIconText.setText(R.string.text_gov);
    }

    @Override
    public void initView() {
//        centerIcon.setImageResource(R.drawable.btn_gov_selected);
    }
}

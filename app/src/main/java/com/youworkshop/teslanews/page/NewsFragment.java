package com.youworkshop.teslanews.page;

import android.view.View;

import com.youworkshop.teslanews.R;
import com.youworkshop.teslanews.base.BaseFragment;

/**
 * Created by Tony on 2017/12/9.
 */

public class NewsFragment extends BaseFragment {
    @Override
    public void initData() {
        tabTitle.setText("News");
        tabType.setVisibility(View.GONE);
    }

    @Override
    public void initView() {
        centerIcon.setImageResource(R.drawable.btn_news_selected);
    }
}

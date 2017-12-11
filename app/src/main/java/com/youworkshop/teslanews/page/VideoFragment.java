package com.youworkshop.teslanews.page;

import com.youworkshop.teslanews.R;
import com.youworkshop.teslanews.base.BaseFragment;

/**
 * Created by Tony on 2017/12/9.
 */

public class VideoFragment extends BaseFragment {
    @Override
    public void initData() {
        tabTitle.setText(R.string.tab_video);
        centerIconText.setText(R.string.text_video);
    }

    @Override
    public void initView() {
//        centerIcon.setImageResource(R.drawable.btn_video_selected);
    }
}

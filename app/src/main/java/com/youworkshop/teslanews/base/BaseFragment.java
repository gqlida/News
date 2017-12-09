package com.youworkshop.teslanews.base;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.youworkshop.teslanews.R;
import com.youworkshop.teslanews.activity.HomeActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Tony on 2017/12/9.
 */

public class BaseFragment extends Fragment {

    @BindView(R.id.tab_sliding)
    public Button tabSliding;
    @BindView(R.id.tab_title)
    public TextView tabTitle;
    @BindView(R.id.tab_type)
    public Button tabType;
    Unbinder unbinder;
    @BindView(R.id.centerIcon)
    public ImageView centerIcon;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_base, null);
        unbinder = ButterKnife.bind(this, view);
        initView();
        return view;
    }

    public void initView() {
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
        tabSliding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeActivity activity = (HomeActivity) getActivity();
                activity.getSlidingMenu().toggle();
            }
        });
    }

    public void initData() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}

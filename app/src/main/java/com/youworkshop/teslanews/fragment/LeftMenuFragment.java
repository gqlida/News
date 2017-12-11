package com.youworkshop.teslanews.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.youworkshop.teslanews.R;
import com.youworkshop.teslanews.activity.HomeActivity;
import com.youworkshop.teslanews.bean.EventBusMesInfo;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 左侧的菜单
 * Created by Tony on 2017/12/9.
 */

public class LeftMenuFragment extends Fragment {
    String[] slidingName = {"新闻", "专题", "组图", "互动"};
    @BindView(R.id.ll_leftMenu)
    ListView llLeftMenu;
    Unbinder unbinder;
    @BindView(R.id.ll_leftMenu_above)
    LinearLayout llLeftMenuAbove;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_leftmenu, null);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final leftMenuAdapter leftMenuAdapter = new leftMenuAdapter();
        llLeftMenu.setAdapter(new leftMenuAdapter());
        llLeftMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                leftMenuAdapter.notifyDataSetChanged();
                HomeActivity activity = (HomeActivity) getActivity();
                activity.getSlidingMenu().toggle();
                EventBus.getDefault().post(new EventBusMesInfo(position));
            }
        });
        int heightPixels = getActivity().getResources().getDisplayMetrics().heightPixels;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, heightPixels / 3);
        llLeftMenuAbove.setLayoutParams(layoutParams);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private class leftMenuAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return slidingName.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @SuppressLint("ViewHolder")
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = View.inflate(getActivity(), R.layout.item_leftmenu, null);
            TextView leftMenuText = convertView.findViewById(R.id.leftMenu_text);
            leftMenuText.setText(slidingName[position]);
            return convertView;
        }
    }
}

package com.youworkshop.teslanews.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.youworkshop.teslanews.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Tony on 2017/12/9.
 */

public class LeftMenuFragment extends Fragment {
    String[] slidingName = {"News", "News", "News", "News"};
    @BindView(R.id.ll_leftMenu)
    ListView llLeftMenu;
    Unbinder unbinder;

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
        llLeftMenu.setAdapter(new leftMenuAdapter());
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

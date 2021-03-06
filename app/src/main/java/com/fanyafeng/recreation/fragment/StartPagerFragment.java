package com.fanyafeng.recreation.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.facebook.drawee.view.SimpleDraweeView;
import com.fanyafeng.recreation.R;
import com.fanyafeng.recreation.util.FrescoUtil;
import com.fanyafeng.recreation.util.StringUtil;

public class StartPagerFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_PARAM3 = "param3";

    private String mParam1;
    private int mParam2=0;
    private String mParam3;

    private SimpleDraweeView sdvStart;

    public StartPagerFragment() {
        // Required empty public constructor
    }

    public static StartPagerFragment newInstance(String param1, int param2, String param3) {
        StartPagerFragment fragment = new StartPagerFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putInt(ARG_PARAM2, param2);
        args.putString(ARG_PARAM3, param3);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getInt(ARG_PARAM2);
            mParam3 = getArguments().getString(ARG_PARAM3);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_start_pager, container, false);
        sdvStart = (SimpleDraweeView) view.findViewById(R.id.sdvStart);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (mParam2 != 0) {
            FrescoUtil.loadGifPicInApp(sdvStart, mParam2);
        }
        if (!StringUtil.isNullOrEmpty(mParam3)) {
            FrescoUtil.loadGifPicOnNet(sdvStart, mParam3);
        }
    }
}

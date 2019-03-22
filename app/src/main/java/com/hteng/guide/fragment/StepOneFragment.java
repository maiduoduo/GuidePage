package com.hteng.guide.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.hteng.guide.R;

/**
 * 开发者：jimmyzhang
 * 日期：2017/3/12
 * Copyright (C) 2017 华腾信息科技有限公司
 * 版权所有
 */

public class StepOneFragment extends Fragment implements View.OnClickListener {

    private ImageView viewById;
    private LinearLayout llDotVisible;
    private TextView tvonLogin;
    private TextView tvonMain;
    private TextView pagerTitle;
    private TextView pagerDes;
    private int imgRes = 0;
    private String title = "";
    private String des = "";
    private boolean isVisible = false;
    public static StepOneFragment newInstance() {
        return new StepOneFragment();
    }


    private void initView(View view) {
        viewById = (ImageView) view.findViewById(R.id.rlImgBg);
        llDotVisible = (LinearLayout) view.findViewById(R.id.llDotVisible);
        tvonLogin = (TextView) view.findViewById(R.id.tvonLogin);
        tvonMain = (TextView) view.findViewById(R.id.tvonMain);
        pagerTitle = (TextView) view.findViewById(R.id.pager_text_title);
        pagerDes = (TextView) view.findViewById(R.id.pager_text_info);
        if (viewById != null && imgRes != 0) viewById.setImageResource(imgRes);
        if (pagerTitle != null) pagerTitle.setText(title);
        if (pagerDes != null) pagerDes.setText(des);
    }

    private void initListeners() {
        tvonLogin.setOnClickListener(this);
        tvonMain.setOnClickListener(this);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(final LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_step_one, container, false);
        initView(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initListeners();
    }

    public void setGuideImage(int imgRes){
        this.imgRes = imgRes;
        if (viewById != null && imgRes != 0) viewById.setImageResource(imgRes);
    }

    public void setGuideText(String title,String des){
        this.title = title;
        this.des = des;
        if (pagerTitle != null) pagerTitle.setText(title);
        if (pagerDes != null) pagerDes.setText(des);
    }

    public void setGuideButtonVisible(boolean isVisible){
        this.isVisible = isVisible;
        if (llDotVisible != null) {
            if (isVisible)
                llDotVisible.setVisibility(View.VISIBLE);
            else
                llDotVisible.setVisibility(View.GONE);
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tvonLogin:
                Toast.makeText(getActivity(), "登录/注册", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tvonMain:
                Toast.makeText(getActivity(), "立即体验", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}

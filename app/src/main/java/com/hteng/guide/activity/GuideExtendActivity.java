package com.hteng.guide.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.hteng.guide.PageTextBean;
import com.hteng.guide.R;

import java.util.ArrayList;
import java.util.List;

/**
 * author：JSYL-DCL on 2019/2/19
 */
public class GuideExtendActivity extends GuideActivity {
    private List<PageTextBean> pageTextBeans  = new ArrayList<>();
    //默认演示图片资源
    private List<Integer> imgList  = new ArrayList<>();
    private int size = 4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        GuideActivity.init()
//                .setWidth(88)
//                .setMargin(66)
//                .setHeight(22)
//                .addDot(true)
//                .pageTitleRes(pageTextBeans)
//        .defaultPage(true);

    }

    @Override
    public int setMargin() {
        return 66;
    }

    @Override
    public int setWidth() {
        return 88;
    }

    @Override
    public int setHeight() {
        return 22;
    }

    @Override
    public boolean addDot() {
        return true;
    }

    @Override
    public boolean defaultPage() {
        return true;
    }

    @Override
    public List<Integer> useDefaultPage() {
        if (imgList != null)imgList.clear();
        imgList.add(R.mipmap.guide_a);
        imgList.add(R.mipmap.guide_b);
        imgList.add(R.mipmap.guide_c);
        imgList.add(R.mipmap.guide_d);
        imgList.add(R.mipmap.b44);
        imgList.add(R.mipmap.b42);
        imgList.add(R.mipmap.b43);
        return imgList;
    }

    @Override
    public List<Fragment> useCustomPage() {
        return null;
    }

    @Override
    public List<PageTextBean> pageTitleRes() {
        if (pageTextBeans != null)pageTextBeans.clear();
        pageTextBeans.add(new PageTextBean(getResources().getString(R.string.guid_text_one_title),getResources().getString(R.string.guid_text_one_info)));
        pageTextBeans.add(new PageTextBean(getResources().getString(R.string.guid_text_one_title),getResources().getString(R.string.guid_text_one_info)));
        pageTextBeans.add(new PageTextBean(getResources().getString(R.string.guid_text_two_title),getResources().getString(R.string.guid_text_two_info)));
        pageTextBeans.add(new PageTextBean(getResources().getString(R.string.guid_text_two_title),getResources().getString(R.string.guid_text_two_info)));
        pageTextBeans.add(new PageTextBean(getResources().getString(R.string.guid_text_two_title),getResources().getString(R.string.guid_text_two_info)));
        pageTextBeans.add(new PageTextBean(getResources().getString(R.string.guid_text_two_title),getResources().getString(R.string.guid_text_two_info)));
        pageTextBeans.add(new PageTextBean(getResources().getString(R.string.guid_text_two_title),getResources().getString(R.string.guid_text_two_info)));
        pageTextBeans.add(new PageTextBean(getResources().getString(R.string.guid_text_three_title),getResources().getString(R.string.guid_text_three_info)));
        pageTextBeans.add(new PageTextBean(getResources().getString(R.string.guid_text_three_title),getResources().getString(R.string.guid_text_three_info)));
        pageTextBeans.add(new PageTextBean(getResources().getString(R.string.guid_text_three_title),getResources().getString(R.string.guid_text_three_info)));
        pageTextBeans.add(new PageTextBean(getResources().getString(R.string.guid_text_three_title),getResources().getString(R.string.guid_text_three_info)));
        pageTextBeans.add(new PageTextBean(getResources().getString(R.string.guid_text_four_title),getResources().getString(R.string.guid_text_four_info)));
        pageTextBeans.add(new PageTextBean(getResources().getString(R.string.guid_text_four_title),getResources().getString(R.string.guid_text_four_info)));
        pageTextBeans.add(new PageTextBean(getResources().getString(R.string.guid_text_four_title),getResources().getString(R.string.guid_text_four_info)));
        pageTextBeans.add(new PageTextBean(getResources().getString(R.string.guid_text_four_title),getResources().getString(R.string.guid_text_four_info)));
        pageTextBeans.add(new PageTextBean(getResources().getString(R.string.guid_text_four_title),getResources().getString(R.string.guid_text_four_info)));
        pageTextBeans.add(new PageTextBean(getResources().getString(R.string.guid_text_four_title),getResources().getString(R.string.guid_text_four_info)));
        pageTextBeans.add(new PageTextBean(getResources().getString(R.string.guid_text_four_title),getResources().getString(R.string.guid_text_four_info)));
        pageTextBeans.add(new PageTextBean(getResources().getString(R.string.guid_text_four_title),getResources().getString(R.string.guid_text_four_info)));
        pageTextBeans.add(new PageTextBean(getResources().getString(R.string.guid_text_four_title),getResources().getString(R.string.guid_text_four_info)));
        pageTextBeans.add(new PageTextBean(getResources().getString(R.string.guid_text_four_title),getResources().getString(R.string.guid_text_four_info)));
        pageTextBeans.add(new PageTextBean(getResources().getString(R.string.guid_text_four_title),getResources().getString(R.string.guid_text_four_info)));
        return pageTextBeans;
    }


}

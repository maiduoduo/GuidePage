package com.hteng.guide.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.hteng.guide.PageTextBean;
import com.hteng.guide.R;
import com.hteng.guide.adapter.GuidePageAdapter;
import com.hteng.guide.fragment.StepOneFragment;
import com.hteng.guide.fragment.StepThreeFragment;
import com.hteng.guide.fragment.StepTwoFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 引导页基类界面
 * @author JSYL-DCL
 */

public abstract class GuideActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    private ViewPager mViewPager;
    private GuidePageAdapter mPageAdapter;
    private List<Fragment> mFragments;
    private LinearLayout mDotLayout;
    private ImageView[] dots;
    private int currentIndex;
    private int marginPx = 0;
    private int widthPx = 0;
    private int heightpx = 0;
    private boolean isdot = false;
    private List<PageTextBean> pageTextList = new ArrayList<>();
    //默认演示图片资源
    private List<Integer> guideImgList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //去掉状态栏
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
        setContentView(R.layout.activity_guide);
        if (pageTextList != null)pageTextList.clear();
        if (guideImgList != null)guideImgList.clear();
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            // 透明状态栏
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            // 透明导航栏
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
//        }
        getSupportActionBar().hide();
        int i = setMargin();
        boolean b = addDot();
        List<PageTextBean> pageTextBeans = pageTitleRes();
        List<Integer> integers = useDefaultPage();
        pageTextList.addAll(pageTextBeans);
        guideImgList.addAll(integers);
        initView();
        initData();
        initDots();
        initListeners();
    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.guide_view_pager);
        mDotLayout = (LinearLayout) findViewById(R.id.dots_layout);

    }

    private void initData() {
        mFragments = new ArrayList<Fragment>();
        for (int i = 0; i < guideImgList.size(); i++) {
            StepOneFragment stepOneFragment = new StepOneFragment();
            stepOneFragment.setGuideImage(guideImgList.get(i));
            if (pageTextList != null) {
                stepOneFragment.setGuideText(pageTextList.get(i).pageTitle, pageTextList.get(i).pageInfo);
            }
            mFragments.add(stepOneFragment);
            ImageView guideIv = new ImageView(GuideActivity.this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(26, 18);
            params.leftMargin = 8;
            guideIv.setLayoutParams(params);
            mDotLayout.addView(guideIv);
        }
        mPageAdapter = new GuidePageAdapter(getSupportFragmentManager(), mFragments);
        mViewPager.setAdapter(mPageAdapter);
        mViewPager.setCurrentItem(0);
        StepOneFragment fragment = (StepOneFragment) mFragments.get(0);
        fragment.setGuideImage(guideImgList.get(0));
        fragment.setGuideText(pageTextList.get(0).pageTitle,pageTextList.get(0).pageInfo);
        fragment.setGuideButtonVisible(false);
    }

    private void initListeners() {

        mViewPager.addOnPageChangeListener(this);
    }

    private void initDots() {
        dots = new ImageView[mFragments.size()];
        for (int i = 0; i < mFragments.size(); i++) {
            dots[i] = (ImageView) mDotLayout.getChildAt(i);
            if (i != 0) {
                dots[i].setImageResource(R.drawable.ic_circle_dot);
            }
        }
        currentIndex = 0;
        dots[currentIndex].setImageResource(R.drawable.ic_rect_dot);
    }

    private void setCurrentDot(int position) {

        if (position < 0 || position > mFragments.size() - 1
                || currentIndex == position) {
            return;
        }
        dots[position].setImageDrawable(null);
        dots[position].setImageResource(R.drawable.ic_rect_dot);
        dots[currentIndex].setImageDrawable(null);
        dots[currentIndex].setImageResource(R.drawable.ic_circle_dot);
        currentIndex = position;
    }



    // 当前页面被滑动时调用
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    // 当新的页面被选中时调用
    @Override
    public void onPageSelected(int position) {
        // 设置底部小点选中状态
        setCurrentDot(position);
        StepOneFragment fragment = (StepOneFragment) mFragments.get(position);
        fragment.setGuideImage(guideImgList.get(position));
        fragment.setGuideText(pageTextList.get(position).pageTitle,pageTextList.get(position).pageInfo);
        if (position == mFragments.size() - 1){
            fragment.setGuideButtonVisible(true);
        }else {
            fragment.setGuideButtonVisible(false);
        }
    }

    // 当滑动状态改变时调用
    @Override
    public void onPageScrollStateChanged(int state) {
    }


    public abstract int setMargin();

    public abstract int setWidth();

    public abstract int setHeight();

    public abstract boolean addDot();

    /**
     * 使用默认提供的界面
     * @return
     */
    public abstract boolean defaultPage();

    /**
     * 使用默认提供的界面
     *      如果同时配置默认界面和自定义界面都为true,默认使用默认模式
     * @return
     */
    public abstract List<Integer> useDefaultPage();


    /**
     * 使用默认提供的界面
     * @return
     */
    public abstract List<Fragment> useCustomPage();

    /**
     * 标题资源
     *   bean应该封装成公共类
     * @return
     */
    public abstract List<PageTextBean>  pageTitleRes();

}

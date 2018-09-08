package com.example.jie.sign.Fragment.Main;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.jie.sign.Adapter.MainAdapter;
import com.example.jie.sign.BaseTemplate.BaseLazyFragment;
import com.example.jie.sign.CustomView.MessageTabButton;

import com.example.jie.sign.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by handsome on 2016/4/7.
 */
public class MessageFragment extends BaseLazyFragment implements ViewPager.OnPageChangeListener{

    @Override
    public int getLayoutId() {
        return R.layout.fragment_message;
    }

    @Override
    public void initViews() {

    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
        setTitle("消息");
//        //初始化碎片
//        initFragments();
    }

    @Override
    public void processClick(View v) {

    }
    /**
     * 初始化碎片
     */
    private void initFragments() {

    }
    public void selectPager(int position){

    }
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }
    @Override
    public void onPageSelected(int position) {

    }
    @Override
    public void onPageScrollStateChanged(int state) {

    }
}

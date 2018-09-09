package com.example.jie.sign.View;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.example.jie.sign.Adapter.MainAdapter;
import com.example.jie.sign.BaseTemplate.BaseActivity;
import com.example.jie.sign.Fragment.Main.AllFragment;
import com.example.jie.sign.Fragment.Main.FinishedFragment;
import com.example.jie.sign.Fragment.Main.UnFinishedFragment;
import com.example.jie.sign.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YX on 2018/9/8.
 */

public class MeetingCheckActivity extends BaseActivity implements ViewPager.OnPageChangeListener {
    private TextView tv_all;//全部
    private TextView tv_unfinished;//未结束
    private TextView tv_finished;//已结束
    private ViewPager vp_main;
    private List<Fragment> list;
    private MainAdapter adapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_meeting_check;
    }

    @Override
    public void initViews() {
        tv_all = findView(R.id.tv_all);
        tv_unfinished = findView(R.id.tv_unfinished);
        tv_finished = findView(R.id.tv_finished);
        vp_main = findView(R.id.vp_main);
    }

    @Override
    public void initListener() {
        tv_all.setOnClickListener(this);
        tv_unfinished.setOnClickListener(this);
        tv_finished.setOnClickListener(this);
        vp_main.setOnPageChangeListener(this);
    }

    @Override
    public void initData() {
        initFragments();
    }

    private void initFragments() {
        list = new ArrayList<>();
        list.add(new AllFragment());
        list.add(new UnFinishedFragment());
        list.add(new FinishedFragment());
        adapter = new MainAdapter(getSupportFragmentManager(), list);
        vp_main.setAdapter(adapter);
        vp_main.setOffscreenPageLimit(2);
        Light(0);
    }

    @Override
    public void processClick(View v) {
        switch (v.getId()) {
            case R.id.tv_all:
                Light(0);
                break;
            case R.id.tv_unfinished:
                Light(1);
                break;
            case R.id.tv_finished:
                Light(2);
                break;
            default:
                break;
        }
    }

    //高亮
    public void Light(int position) {
        vp_main.setCurrentItem(position, false);
        tv_all.setTextColor(position == 0 ? Color.parseColor("#FFFFFF") : Color.parseColor("#303f9f"));
        tv_unfinished.setTextColor(position == 1 ? Color.parseColor("#FFFFFF") : Color.parseColor("#303f9f"));
        tv_finished.setTextColor(position == 2 ? Color.parseColor("#FFFFFF") : Color.parseColor("#303f9f"));
        tv_all.setBackgroundResource(position == 0 ? R.drawable.background_blue : R.drawable.background_gray);
        tv_unfinished.setBackgroundResource(position == 1 ? R.drawable.background_blue : R.drawable.background_gray);
        tv_finished.setBackgroundResource(position == 2 ? R.drawable.background_blue : R.drawable.background_gray);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        Light(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}

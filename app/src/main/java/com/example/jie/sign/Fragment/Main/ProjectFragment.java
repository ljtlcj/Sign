package com.example.jie.sign.Fragment.Main;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;

import com.example.jie.sign.BaseTemplate.BaseLazyFragment;
import com.example.jie.sign.CustomView.FastMenuBar;

import com.example.jie.sign.R;
import com.example.jie.sign.View.MeetingCheck;


/**
 * Created by Diko(kedongyu) on 2016/4/7.
 * 本界面对应主界面-项目
 */
public class ProjectFragment extends BaseLazyFragment {


    private LinearLayout ly_meeting_check;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_project;
    }

    @Override
    public void initViews() {
        ly_meeting_check = findView(R.id.ly_meeting_check);

    }

    @Override
    public void initListener() {
        ly_meeting_check.setOnClickListener(this);
    }

    @Override
    public void initData() {
        setTitle("功能");
    }

    @Override
    public void processClick(View v) {
        switch (v.getId()){
            case R.id.ly_meeting_check:
                startActivity(MeetingCheck.class);
                break;
            default:
                break;
        }
    }
}

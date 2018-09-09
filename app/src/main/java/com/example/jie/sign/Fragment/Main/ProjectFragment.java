package com.example.jie.sign.Fragment.Main;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.jie.sign.BaseTemplate.BaseLazyFragment;

import com.example.jie.sign.R;
import com.example.jie.sign.View.MeetingCheckActivity;
import com.example.jie.sign.View.MeetingRoomActivity;


/**
 * Created by Diko(kedongyu) on 2016/4/7.
 * 本界面对应主界面-项目
 */
public class ProjectFragment extends BaseLazyFragment {


    private LinearLayout ly_meeting_check;
    private LinearLayout ly_check_meeting_room;//查看会议室

    @Override
    public int getLayoutId() {
        return R.layout.fragment_project;
    }

    @Override
    public void initViews() {
        ly_meeting_check = findView(R.id.ly_meeting_check);
        ly_check_meeting_room = findView(R.id.ly_check_meeting_room);
    }

    @Override
    public void initListener() {
        ly_meeting_check.setOnClickListener(this);
        ly_check_meeting_room.setOnClickListener(this);
    }

    @Override
    public void initData() {
        setTitle("功能");
    }

    @Override
    public void processClick(View v) {
        switch (v.getId()){
            case R.id.ly_meeting_check:
                startActivity(MeetingCheckActivity.class);
                break;
            case R.id.ly_check_meeting_room:
                startActivity(MeetingRoomActivity.class);
                break;
            default:
                break;
        }
    }
}

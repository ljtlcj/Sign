package com.example.jie.sign.View;

import android.view.View;

import com.example.jie.sign.BaseTemplate.BaseActivity;
import com.example.jie.sign.R;

/**
 * Created by YX on 2018/9/9.
 */

public class MeetingRoomAddActivity extends BaseActivity {
    @Override
    public int getLayoutId() {
        return R.layout.activity_meeting_room_add;
    }

    @Override
    public void initViews() {

    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
        setTitle("添加");
        setTitleCanBack();
        setEdit2("保存");
    }

    @Override
    public void processClick(View v) {

    }
}

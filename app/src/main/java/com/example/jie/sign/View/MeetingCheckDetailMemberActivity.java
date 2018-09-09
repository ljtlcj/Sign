package com.example.jie.sign.View;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.jie.sign.BaseTemplate.BaseActivity;
import com.example.jie.sign.R;

/**
 * Created by jie on 2018/9/8.
 */

public class MeetingCheckDetailMemberActivity extends BaseActivity {
    private RecyclerView recyclerView;

    @Override
    public int getLayoutId() {
        return R.layout.activity_meeting_check_detail_member;
    }

    @Override
    public void initViews() {
        recyclerView = findView(R.id.RecylerView);
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
        setTitleCanBack();
        setTitle("人员列表");
    }

    @Override
    public void processClick(View v) {

    }
}

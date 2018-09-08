package com.example.jie.sign.View;

import android.view.View;
import android.widget.TextView;

import com.example.jie.sign.BaseTemplate.BaseActivity;
import com.example.jie.sign.R;

/**
 * Created by jie on 2018/9/8.
 */

public class MeetingCheckDetailActivity extends BaseActivity{
    private TextView tv_member;
    private TextView tv_no_member;
    private TextView tv_has_member;
    @Override
    public int getLayoutId() {
        return R.layout.activity_meeting_check_detail;
    }

    @Override
    public void initViews() {
        tv_member = findView(R.id.tv_member);
        tv_no_member = findView(R.id.tv_no_member);
        tv_has_member = findView(R.id.tv_has_member);
    }

    @Override
    public void initListener() {
        tv_member.setOnClickListener(this);
        tv_no_member.setOnClickListener(this);
        tv_has_member.setOnClickListener(this);
    }

    @Override
    public void initData() {
        setTitleCanBack();
        setTitle("会议信息");
    }

    @Override
    public void processClick(View v) {
        switch (v.getId()){
            case R.id.tv_member:
                startActivity(MeetingCheckDetailMemberActivity.class);
                break;
            case R.id.tv_no_member:
                startActivity(MeetingCheckDetailMemberActivity.class);
                break;
            case R.id.tv_has_member:
                startActivity(MeetingCheckDetailMemberActivity.class);
                break;
            default:
                break;
        }
    }
}

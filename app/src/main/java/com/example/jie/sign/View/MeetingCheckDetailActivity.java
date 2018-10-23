package com.example.jie.sign.View;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jie.sign.BaseTemplate.BaseActivity;
import com.example.jie.sign.Bean.AllMeetingNewsBean;
import com.example.jie.sign.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jie on 2018/9/8.
 */

public class MeetingCheckDetailActivity extends BaseActivity {
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.iv_finish)
    ImageView ivFinish;
    @BindView(R.id.tv_edit)
    TextView tvEdit;
    @BindView(R.id.tv_edit2)
    TextView tvEdit2;
    @BindView(R.id.meeting_name)
    TextView meetingName;
    @BindView(R.id.tv_member)
    TextView tvMember;
    @BindView(R.id.fmb_menu_arrow)
    ImageView fmbMenuArrow;
    @BindView(R.id.tv_has_member)
    TextView tvHasMember;
    @BindView(R.id.tv_no_member)
    TextView tvNoMember;
    @BindView(R.id.Meeting_local)
    TextView MeetingLocal;
    @BindView(R.id.Meeting_time)
    TextView MeetingTime;
    @BindView(R.id.id_id)
    TextView idId;
    @BindView(R.id.meeting_content)
    TextView meetingContent;
    private ArrayList<AllMeetingNewsBean> arr;
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
        ButterKnife.bind(this);
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
        getdata();
    }

    private void getdata() {
        Intent intent = this.getIntent();
        arr = intent.getParcelableArrayListExtra("data");
        Log.e("getdata: ", String.valueOf(arr.get(0).getId()));
        inview();
    }

    private void inview() {
        idId.setText(arr.get(0).getId());
        meetingContent.setText(arr.get(0).getMeeting_content());
        meetingName.setText(arr.get(0).getMeeting_name());
        MeetingTime.setText(arr.get(0).getMeeting_time());
        MeetingLocal.setText(arr.get(0).getRoom_id());
    }

    @Override
    public void processClick(View v) {
        switch (v.getId()) {
            case R.id.tv_member:
                Intent intent = new Intent(MeetingCheckDetailActivity.this, MeetingCheckDetailMemberActivity.class);
                intent.putExtra("id",idId.getText().toString().trim());
                startActivity(intent);
//                startActivity(MeetingCheckDetailMemberActivity.class);
                break;
            case R.id.tv_no_member:
                Intent intent1 = new Intent(MeetingCheckDetailActivity.this, MeetingCheckDetailNoMemberActivity.class);
                intent1.putExtra("id",idId.getText().toString().trim());
                startActivity(intent1);
                break;
            case R.id.tv_has_member:
                Intent intent2 = new Intent(MeetingCheckDetailActivity.this, MeetingCheckDetailArrivalMemberActivity.class);
                intent2.putExtra("id",idId.getText().toString().trim());
                startActivity(intent2);
                break;
            default:
                break;

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}

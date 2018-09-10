package com.example.jie.sign.View.AddMeeting;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.codbking.widget.DatePickDialog;
import com.codbking.widget.OnSureLisener;
import com.codbking.widget.bean.DateType;
import com.example.jie.sign.BaseTemplate.BaseActivity;
import com.example.jie.sign.Bean.DialogMemberBean;
import com.example.jie.sign.R;
import com.example.jie.sign.Utils.DialogHelper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by jie on 2018/9/9.
 */

public class MeetingAddActivity extends BaseActivity implements DialogHelper.OnHelperSelectorListener  {
    private TextView sign_stime;
    private TextView sign_etime;
    private TextView meeting_time;
    private TextView tv_member;
    private TextView tv_location;
    private List<DialogMemberBean> mSimpleListItemEntity = new ArrayList<>();
    @Override
    public int getLayoutId() {
        return R.layout.activity_meeting_add;
    }

    @Override
    public void initViews() {
        sign_etime = findView(R.id.tv_sign_etime);
        sign_stime = findView(R.id.tv_sign_stime);
        meeting_time = findView(R.id.tv_meeting_time);
        tv_member = findView(R.id.tv_member);
        tv_location = findView(R.id.tv_location);
    }

    @Override
    public void initListener() {
        sign_etime.setOnClickListener(this);
        sign_stime.setOnClickListener(this);
        meeting_time.setOnClickListener(this);
        tv_member.setOnClickListener(this);
        tv_location.setOnClickListener(this);
    }

    @Override
    public void initData() {
        setTitleCanBack();
        setTitle("添加会议");
        for (int i = 0; i < 30; i++) {
            DialogMemberBean simpleListItemEntity = new DialogMemberBean();
            simpleListItemEntity.setNumber(i + "");
            simpleListItemEntity.setName("星期" + i);
            simpleListItemEntity.setSelector(false);
            mSimpleListItemEntity.add(simpleListItemEntity);
        }
    }

    @Override
    public void processClick(View v) {
        switch (v.getId()){
            case R.id.tv_sign_etime:
                selecttime(v,1);
                break;
            case R.id.tv_sign_stime:
                selecttime(v,2);
                break;
            case R.id.tv_meeting_time:
                selecttime(v,3);
                break;
            case R.id.tv_member:
                DialogHelper.create(this).setSelectorData(mSimpleListItemEntity).setStyle(1).setSelectorListener(this)
                        .showSelectorDialog();
                break;
            case R.id.tv_location:
                DialogHelper.create(this).setSelectorData(mSimpleListItemEntity).setStyle(0).setSelectorListener(this)
                        .showSelectorDialog();
                break;
            default:
                break;
        }
    }

    private void selecttime(final View view,final int type) {
        DatePickDialog dialog = new DatePickDialog(this);
        //设置上下年分限制
        dialog.setYearLimt(8);
        //设置标题
        dialog.setTitle("选择时间");
        //设置类型
        dialog.setType(DateType.TYPE_YMDHM);
        //设置消息体的显示格式，日期格式
        dialog.setMessageFormat("yyyy-MM-dd HH:mm");
        //设置选择回调
        dialog.setOnChangeLisener(null);
        //设置点击确定按钮回调
        dialog.setOnSureLisener(new OnSureLisener() {
            @Override
            public void onSure(Date date) {
               if (type==1){
                   sign_etime.setText(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date));
               }else if (type == 2){
                   sign_stime.setText(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date));
               }else if (type == 3){
                   meeting_time.setText(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(date));
               }
            }
        });
        dialog.show();
    }


    @Override
    public void getSelectorPosition(List<DialogMemberBean> trees) {
        Log.e("getSelectorPosition:",String.valueOf(trees));
    }
}

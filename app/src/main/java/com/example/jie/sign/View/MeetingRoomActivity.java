package com.example.jie.sign.View;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.jie.sign.Adapter.MeetingRoomAdapter;
import com.example.jie.sign.BaseTemplate.BaseActivity;
import com.example.jie.sign.Bean.MeetingRoomBean;
import com.example.jie.sign.R;
import com.example.jie.sign.Utils.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YX on 2018/9/9.
 */

public class MeetingRoomActivity extends BaseActivity {
    private Button btn_add;//添加
    List<MeetingRoomBean> list = new ArrayList<>();
    private RecyclerView rv_list;
    private MeetingRoomAdapter adapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_meeting_room;
    }

    @Override
    public void initViews() {
        //btn_add = findView(R.id.btn_add);
        rv_list = findView(R.id.rv_list);
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
        setTitleCanBack();
        setTitle("查看会议室");
        setEdit2("添加");
//        for (int i = 0; i < 5; i++) {
//            MeetingRoomBean meetingRoomBean = new MeetingRoomBean("锡科61401", "查看详情");
//            list.add(meetingRoomBean);
//        }
        MeetingRoomBean meetingRoomBean = new MeetingRoomBean("锡科614", "查看详情");
        MeetingRoomBean meetingRoomBean2 = new MeetingRoomBean("田师212", "查看详情");
        MeetingRoomBean meetingRoomBean3 = new MeetingRoomBean("工楼B14", "查看详情");
        MeetingRoomBean meetingRoomBean4 = new MeetingRoomBean("锡科503", "查看详情");
        MeetingRoomBean meetingRoomBean5 = new MeetingRoomBean("教科440", "查看详情");
        MeetingRoomBean meetingRoomBean6 = new MeetingRoomBean("工楼A10", "查看详情");
        MeetingRoomBean meetingRoomBean7= new MeetingRoomBean("锡科201", "查看详情");
        MeetingRoomBean meetingRoomBean8= new MeetingRoomBean("工楼C12", "查看详情");
        MeetingRoomBean meetingRoomBean9= new MeetingRoomBean("锡科208", "查看详情");
        list.add(meetingRoomBean);
        list.add(meetingRoomBean2);
        list.add(meetingRoomBean3);
        list.add(meetingRoomBean4);
        list.add(meetingRoomBean5);
        list.add(meetingRoomBean6);
        list.add(meetingRoomBean7);
        list.add(meetingRoomBean8);
        list.add(meetingRoomBean9);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rv_list.setLayoutManager(layoutManager);
        adapter = new MeetingRoomAdapter(list);
        adapter.setmOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(MeetingRoomActivity.this, String.valueOf(position), Toast.LENGTH_SHORT).show();
            }
        });
        rv_list.setAdapter(adapter);
    }

    @Override
    public void processClick(View v) {
        switch (v.getId()) {
            case R.id.tv_edit2:
                startActivity(MeetingRoomAddActivity.class);
                break;
            default:
                break;
        }
    }
}

package com.example.jie.sign.View;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.jie.sign.Adapter.MeetingCheckAdapter;
import com.example.jie.sign.Adapter.MeetingRoomAdapter;
import com.example.jie.sign.BaseTemplate.BaseActivity;
import com.example.jie.sign.Bean.AllMeetingNewsBean;
import com.example.jie.sign.Bean.MeetingRoomBean;
import com.example.jie.sign.Bean.MeetingRoomBeanUse;
import com.example.jie.sign.Controller.LoginController;
import com.example.jie.sign.Manager.InterfaceManger;
import com.example.jie.sign.R;
import com.example.jie.sign.Utils.OnItemClickListener;
import com.example.jie.sign.Utils.RetrofitUtils;
import com.example.jie.sign.Utils.SpaceItemDecoration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * Created by YX on 2018/9/9.
 */

public class MeetingRoomActivity extends BaseActivity {
    private Button btn_add;//添加
    List<MeetingRoomBeanUse> list = new ArrayList<>();
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
//        MeetingRoomBean meetingRoomBean = new MeetingRoomBean("锡科614", "查看详情");
//        MeetingRoomBean meetingRoomBean2 = new MeetingRoomBean("田师212", "查看详情");
        List<String> photos = new ArrayList<>();
        List<MultipartBody.Part> parts = null;
        Map<String, RequestBody> params = new HashMap<>();
        params.put("unit_id", RetrofitUtils.convertToRequestBody("210"));
        LoginController.memberview2(params, parts, new InterfaceManger.OnRequestListener() {
            @Override
            public void onSuccess(Object success) {
                list = MeetingRoomBeanUse.arrayMeetingRoomBeanUseFromData((String) success);
                LinearLayoutManager layoutManager = new LinearLayoutManager(MeetingRoomActivity.this);
                rv_list.setLayoutManager(layoutManager);
                //rv_list.addItemDecoration(new SpaceItemDecoration(48, 24));
                adapter = new MeetingRoomAdapter(list);
                rv_list.setAdapter(adapter);
            }

            @Override
            public void onError(String error) {
                showToast(error);
            }

            @Override
            public void onComplete() {
            }
        });
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

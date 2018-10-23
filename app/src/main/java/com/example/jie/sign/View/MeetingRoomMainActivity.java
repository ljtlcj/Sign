package com.example.jie.sign.View;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.jie.sign.Adapter.MeetingRoomAdapter;
import com.example.jie.sign.Adapter.MeetingRoomMainAdapter;
import com.example.jie.sign.BaseTemplate.BaseActivity;
import com.example.jie.sign.Bean.MeetingRoomBeanUse;
import com.example.jie.sign.Bean.MeetingRoomMainBean;
import com.example.jie.sign.Controller.LoginController;
import com.example.jie.sign.Manager.InterfaceManger;
import com.example.jie.sign.R;
import com.example.jie.sign.Utils.RetrofitUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * Created by YX on 2018/10/23.
 */

public class MeetingRoomMainActivity extends BaseActivity {

    List<MeetingRoomMainBean> list = new ArrayList<>();
    private RecyclerView rv_list;
    private MeetingRoomMainAdapter adapter;

    @Override
    public int getLayoutId() {
        return R.layout.activity_meeting_room_main;
    }

    @Override
    public void initViews() {
        rv_list = findView(R.id.rv_list);
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
        setTitleCanBack();
        setTitle("查看会议室");
        List<String> photos = new ArrayList<>();
        List<MultipartBody.Part> parts = null;
        Map<String, RequestBody> params = new HashMap<>();
        params.put("unit_id", RetrofitUtils.convertToRequestBody("210"));
        LoginController.memberdel2(params, parts, new InterfaceManger.OnRequestListener() {
            @Override
            public void onSuccess(Object success) {
                list = MeetingRoomMainBean.arrayMeetingRoomMainBeanFromData((String) success);
                LinearLayoutManager layoutManager = new LinearLayoutManager(MeetingRoomMainActivity.this);
                rv_list.setLayoutManager(layoutManager);
                //rv_list.addItemDecoration(new SpaceItemDecoration(48, 24));
                adapter = new MeetingRoomMainAdapter(list);
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

    }
}

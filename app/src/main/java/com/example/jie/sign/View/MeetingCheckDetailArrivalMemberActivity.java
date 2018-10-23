package com.example.jie.sign.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.jie.sign.Adapter.AllMemberAdapter;
import com.example.jie.sign.BaseTemplate.BaseActivity;
import com.example.jie.sign.Bean.AllMemberBean;
import com.example.jie.sign.Controller.LoginController;
import com.example.jie.sign.Manager.InterfaceManger;
import com.example.jie.sign.R;
import com.example.jie.sign.Utils.RetrofitUtils;
import com.example.jie.sign.Utils.SpaceItemDecoration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * Created by jie on 2018/9/8.
 */

public class MeetingCheckDetailArrivalMemberActivity extends BaseActivity {
    @BindView(R.id.RecylerView)
    RecyclerView RecylerView;
    private List<AllMemberBean> lists1 = new ArrayList<AllMemberBean>();//listview数据集
    private AllMemberAdapter adapter;

    private String id;
    @Override
    public int getLayoutId() {
        return R.layout.activity_meeting_check_detail_member;
    }

    @Override
    public void initViews() {
        ButterKnife.bind(this);
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
        setTitleCanBack();
        setTitle("人员列表");
        getid();
        getdata();
    }

    private void getid() {
        Intent intent = this.getIntent();
        id = intent.getStringExtra("id");
        Log.e("getid: ",id);
    }

    private void getdata() {
        List<String> photos = new ArrayList<>();
        List<MultipartBody.Part> parts = null;
        Map<String, RequestBody> params = new HashMap<>();
        params.put("id", RetrofitUtils.convertToRequestBody(id));
        LoginController.arrival_member2(params, parts, new InterfaceManger.OnRequestListener() {
            @Override
            public void onSuccess(Object success) {
                LinearLayoutManager layoutManager = new LinearLayoutManager(MeetingCheckDetailArrivalMemberActivity.this);
                RecylerView.setLayoutManager(layoutManager);
                RecylerView.addItemDecoration(new SpaceItemDecoration(48, 24));
                lists1 = AllMemberBean.arrayAllMemberBeanFromData((String) success);
                Log.e("onSuccess: ",lists1.get(0).getMeeting_member() );
                adapter = new AllMemberAdapter(lists1);
                RecylerView.setAdapter(adapter);

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}

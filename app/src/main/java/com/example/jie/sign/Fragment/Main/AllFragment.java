package com.example.jie.sign.Fragment.Main;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.jie.sign.Adapter.MeetingCheckAdapter;
import com.example.jie.sign.BaseTemplate.BaseLazyFragment;
import com.example.jie.sign.Bean.AllMeetingNewsBean;
import com.example.jie.sign.Controller.LoginController;
import com.example.jie.sign.Manager.InterfaceManger;
import com.example.jie.sign.R;
import com.example.jie.sign.Utils.OnItemClickListener;
import com.example.jie.sign.Utils.RetrofitUtils;
import com.example.jie.sign.Utils.SpaceItemDecoration;
import com.example.jie.sign.View.MeetingCheckDetailActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * Created by handsome on 2016/4/7.
 */
public class AllFragment extends BaseLazyFragment {

    private List<AllMeetingNewsBean> lists1 = new ArrayList<AllMeetingNewsBean>();//listview数据集
    private RecyclerView rv_list;
    private MeetingCheckAdapter adapter;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_all;
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
        getdata();
    }

    private void getdata() {
        List<String> photos = new ArrayList<>();
        List<MultipartBody.Part> parts = null;
        Map<String, RequestBody> params = new HashMap<>();
        params.put("unit_id", RetrofitUtils.convertToRequestBody("210"));
        LoginController.membermeeting2(params, parts, new InterfaceManger.OnRequestListener() {
            @Override
            public void onSuccess(Object success) {
                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                rv_list.setLayoutManager(layoutManager);
                rv_list.addItemDecoration(new SpaceItemDecoration(48, 24));
                lists1 = AllMeetingNewsBean.arrayAllMeetingNewsBeanFromData((String) success);
                adapter = new MeetingCheckAdapter(lists1);
                rv_list.setAdapter(adapter);
                adapter.setOnItemClickListener(new OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        startActivity(MeetingCheckDetailActivity.class);
                    }
                });
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

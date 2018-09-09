package com.example.jie.sign.Fragment.Main;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.jie.sign.Adapter.MeetingCheckAdapter;
import com.example.jie.sign.BaseTemplate.BaseLazyFragment;
import com.example.jie.sign.Bean.MeetingCheckBean;
import com.example.jie.sign.R;
import com.example.jie.sign.Utils.OnItemClickListener;
import com.example.jie.sign.Utils.SpaceItemDecoration;
import com.example.jie.sign.View.MeetingCheckDetailActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by handsome on 2016/4/7.
 */
public class AllFragment extends BaseLazyFragment {

    private RecyclerView rv_list;
    List<MeetingCheckBean> lists = new ArrayList<>();
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
        for (int i = 0; i < 3; i++) {
            MeetingCheckBean meetingCheckBean = new MeetingCheckBean("班会", "锡科61401", "2018-12-05 16:00", true);
            lists.add(meetingCheckBean);
        }
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        rv_list.setLayoutManager(layoutManager);
        rv_list.addItemDecoration(new SpaceItemDecoration(48, 24));
        adapter = new MeetingCheckAdapter(lists);
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getContext(), String.valueOf(position), Toast.LENGTH_SHORT).show();
                startActivity(MeetingCheckDetailActivity.class);
            }
        });
        rv_list.setAdapter(adapter);
    }

    @Override
    public void processClick(View v) {

    }
}

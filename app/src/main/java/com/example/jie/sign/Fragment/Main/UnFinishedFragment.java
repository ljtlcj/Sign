package com.example.jie.sign.Fragment.Main;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.jie.sign.Adapter.MeetingCheckAdapter;
import com.example.jie.sign.BaseTemplate.BaseLazyFragment;
import com.example.jie.sign.Bean.MeetingCheckBean;
import com.example.jie.sign.R;
import com.example.jie.sign.Utils.SpaceItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by handsome on 2016/4/7.
 */
public class UnFinishedFragment extends BaseLazyFragment {
    private RecyclerView rv_list;
    List<MeetingCheckBean> lists = new ArrayList<>();
    private MeetingCheckAdapter adapter;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_unfinished;
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
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        rv_list.setLayoutManager(layoutManager);
        adapter = new MeetingCheckAdapter(lists);
        rv_list.addItemDecoration(new SpaceItemDecoration(48,24));
        rv_list.setAdapter(adapter);

        for(int i=0;i<2;i++){
            MeetingCheckBean meetingCheckBean = new MeetingCheckBean("班会", "锡科61401", "2018-12-05 16:00", true);
            lists.add(meetingCheckBean);
        }
    }

    @Override
    public void processClick(View v) {

    }
}

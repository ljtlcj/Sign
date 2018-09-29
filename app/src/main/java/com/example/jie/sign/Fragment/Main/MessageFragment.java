package com.example.jie.sign.Fragment.Main;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.jie.sign.Adapter.MainAdapter;
import com.example.jie.sign.Adapter.MessageAdapter;
import com.example.jie.sign.BaseTemplate.BaseLazyFragment;
import com.example.jie.sign.Bean.MeetingCheckBean;
import com.example.jie.sign.Bean.MessageBean;
import com.example.jie.sign.CustomView.MessageTabButton;

import com.example.jie.sign.R;
import com.example.jie.sign.Utils.SpaceItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by handsome on 2016/4/7.
 */
public class MessageFragment extends BaseLazyFragment {

    private RecyclerView rv_list;
    List<MessageBean> list = new ArrayList<>();
    private MessageAdapter adapter;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_message;
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
        setTitle("消息");
//        for (int i = 0; i < 3; i++) {
//            MessageBean messageBean = new MessageBean("会议即将开始", "请于2018-9-9 16:30到锡科614开会");
//            list.add(messageBean);
//        }

        MessageBean messageBean = new MessageBean("会议即将开始", "请于2018-11-12 16:30到锡科614开会");
        MessageBean messageBean1 = new MessageBean("会议即将开始", "请于2018-12-9 18:30到田师212开会");
        MessageBean messageBean2 = new MessageBean("会议即将开始", "请于2018-10-9 11:30到工楼B14会");
        MessageBean messageBean3 = new MessageBean("会议结束", "2017-6-9 13:30-锡科504");
        MessageBean messageBean4 = new MessageBean("会议结束", "2017-4-9 9:30-工楼B11");
        list.add(messageBean);
        list.add(messageBean1);
        list.add(messageBean2);
        list.add(messageBean3);
        list.add(messageBean4);


        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        rv_list.setLayoutManager(layoutManager);
        rv_list.addItemDecoration(new SpaceItemDecoration(48, 24));
        adapter = new MessageAdapter(list);
        rv_list.setAdapter(adapter);
    }


    @Override
    public void processClick(View v) {

    }
}

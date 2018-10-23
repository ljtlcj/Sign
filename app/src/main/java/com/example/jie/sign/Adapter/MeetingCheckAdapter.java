package com.example.jie.sign.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jie.sign.Bean.AllMeetingNewsBean;
import com.example.jie.sign.Bean.MeetingCheckBean;
import com.example.jie.sign.R;
import com.example.jie.sign.Utils.OnItemClickListener;

import java.util.List;

/**
 * Created by YX on 2018/9/8.
 */

public class MeetingCheckAdapter extends RecyclerView.Adapter<MeetingCheckAdapter.ViewHolder> {

    private List<AllMeetingNewsBean> list;
    private OnItemClickListener mOnItemClickListener;//声明接口


    public MeetingCheckAdapter(List<AllMeetingNewsBean> list) {
        this.list = list;
    }

    static public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView tv_name;
        private final TextView tv_address;
        private final TextView tv_time;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_address = itemView.findViewById(R.id.tv_address);
            tv_time = itemView.findViewById(R.id.tv_time);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_meeting_check, null);
        final ViewHolder holder = new ViewHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        AllMeetingNewsBean allMeetingNewsBean = list.get(position);
        holder.tv_name.setText(allMeetingNewsBean.getMeeting_name());
        holder.tv_address.setText(allMeetingNewsBean.getRoom_id());
        holder.tv_time.setText(allMeetingNewsBean.getMeeting_time());
        if (mOnItemClickListener != null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mOnItemClickListener.onItemClick(view,position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }
}

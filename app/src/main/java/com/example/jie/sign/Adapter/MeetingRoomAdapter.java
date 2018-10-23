package com.example.jie.sign.Adapter;

import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jie.sign.Bean.MeetingCheckBean;
import com.example.jie.sign.Bean.MeetingRoomBeanUse;
import com.example.jie.sign.R;
import com.example.jie.sign.Utils.OnItemClickListener;

import java.util.List;

/**
 * Created by YX on 2018/9/9.
 */

public class MeetingRoomAdapter extends RecyclerView.Adapter<MeetingRoomAdapter.ViewHolder> {

    private List<MeetingRoomBeanUse> list;
    private OnItemClickListener mOnItemClickListener;//声明接口

    public MeetingRoomAdapter(List<MeetingRoomBeanUse> list) {
        this.list = list;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView tv_meeting_name;//会议名字
        private final TextView tv_meeting_time;
        private final TextView tv_meeting_group;
        private final TextView tv_meeting_id;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_meeting_name = itemView.findViewById(R.id.tv_meeting_name);
            tv_meeting_time = itemView.findViewById(R.id.tv_meeting_time);
            tv_meeting_group = itemView.findViewById(R.id.tv_meeting_group);
            tv_meeting_id = itemView.findViewById(R.id.tv_meeting_id);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_meeting_room, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        MeetingRoomBeanUse meetingRoomBeanUse = list.get(position);
        holder.tv_meeting_name.setText(meetingRoomBeanUse.getUse_location());
        holder.tv_meeting_time.setText(meetingRoomBeanUse.getUse_time());
        holder.tv_meeting_group.setText(meetingRoomBeanUse.getUse_group());
        holder.tv_meeting_id.setText(meetingRoomBeanUse.getRoom_id());
        if (mOnItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mOnItemClickListener.onItemClick(view, position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setmOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }
}

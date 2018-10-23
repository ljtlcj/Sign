package com.example.jie.sign.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jie.sign.Bean.MeetingRoomBeanUse;
import com.example.jie.sign.Bean.MeetingRoomMainBean;
import com.example.jie.sign.R;
import com.example.jie.sign.Utils.OnItemClickListener;

import java.util.List;

/**
 * Created by YX on 2018/9/9.
 */

public class MeetingRoomMainAdapter extends RecyclerView.Adapter<MeetingRoomMainAdapter.ViewHolder> {

    private List<MeetingRoomMainBean> list;
    private OnItemClickListener mOnItemClickListener;//声明接口

    public MeetingRoomMainAdapter(List<MeetingRoomMainBean> list) {
        this.list = list;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView tv_meeting_name;//会议名字
        private final TextView tv_meeting_seat;
        private final TextView tv_meeting_location;
        private final TextView tv_meeting_id;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_meeting_name = itemView.findViewById(R.id.tv_meeting_name);
            tv_meeting_seat = itemView.findViewById(R.id.tv_meeting_seat);
            tv_meeting_location = itemView.findViewById(R.id.tv_meeting_location);
            tv_meeting_id = itemView.findViewById(R.id.tv_meeting_id);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_meeting_room_main, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        MeetingRoomMainBean meetingRoomBeanUse = list.get(position);
        holder.tv_meeting_name.setText(meetingRoomBeanUse.getRoom_name());
        holder.tv_meeting_seat.setText(meetingRoomBeanUse.getSeat_number());
        holder.tv_meeting_location.setText(meetingRoomBeanUse.getRoom_location());
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

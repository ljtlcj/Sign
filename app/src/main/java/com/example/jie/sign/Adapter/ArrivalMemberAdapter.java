package com.example.jie.sign.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jie.sign.Bean.AllMemberBean;
import com.example.jie.sign.R;
import com.example.jie.sign.Utils.OnItemClickListener;

import java.util.List;

/**
 * Created by jie on 2018/10/23.
 */

public class ArrivalMemberAdapter extends RecyclerView.Adapter<ArrivalMemberAdapter.ViewHolder> {

    private List<AllMemberBean> list;
    private OnItemClickListener mOnItemClickListener;//声明接口

    public ArrivalMemberAdapter(List<AllMemberBean> list) {
        this.list = list;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView name;
//        private final TextView id;
        private final TextView phone;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.et_check_man);
//            id = itemView.findViewById(R.id.et_input);
            phone = itemView.findViewById(R.id.et_item_one_name);
        }
    }


    @Override
    public ArrivalMemberAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_meeting_check_detail_member1, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ArrivalMemberAdapter.ViewHolder holder, final int position) {
        AllMemberBean allMemberBean = list.get(position);
        holder.name.setText(allMemberBean.getMeeting_member());
        holder.phone.setText(allMemberBean.getPhonelong());
        if(mOnItemClickListener!=null){
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

    public void setmOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }
}

package com.example.jie.sign.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jie.sign.Bean.MessageBean;
import com.example.jie.sign.R;
import com.example.jie.sign.Utils.OnItemClickListener;

import java.util.List;

/**
 * Created by YX on 2018/9/9.
 */

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder> {

    private List<MessageBean> list;
    private OnItemClickListener mOnItemClickListener;//声明接口

    public MessageAdapter(List<MessageBean> list) {
        this.list = list;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView tv_title;
        private final TextView tv_content;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_content = itemView.findViewById(R.id.tv_content);
        }
    }


    @Override
    public MessageAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_message, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MessageAdapter.ViewHolder holder, final int position) {
        MessageBean messageBean = list.get(position);
        holder.tv_title.setText(messageBean.getTitle());
        holder.tv_content.setText(messageBean.getContent());
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

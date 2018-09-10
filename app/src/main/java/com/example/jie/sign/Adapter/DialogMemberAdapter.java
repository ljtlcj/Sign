package com.example.jie.sign.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.jie.sign.Bean.DialogMemberBean;
import com.example.jie.sign.R;

import java.util.List;

/**
 * Created by jie on 2018/9/9.
 */

public class DialogMemberAdapter extends RecyclerView.Adapter<DialogMemberAdapter.ViewHolder> {
    private List<DialogMemberBean> list;
    private OnItemClickListener mOnItemClickListener;
    static public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView number;
        CheckBox box;
        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_name);
            number = itemView.findViewById(R.id.tv_number);
            box = itemView.findViewById(R.id.box);
        }
    }
    public DialogMemberAdapter(List<DialogMemberBean> list) {
        this.list = list ;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_dialog_item, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        DialogMemberBean lock = list.get(position);
        holder.name.setText(lock.getName());
        holder.number.setText(lock.getNumber());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemClickListener.onItemClick(position);
            }
        });
        holder.box.setChecked(lock.isSelector());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}

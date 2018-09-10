package com.example.jie.sign.CustomView;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.StyleRes;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.jie.sign.Adapter.DialogMemberAdapter;
import com.example.jie.sign.Bean.DialogMemberBean;
import com.example.jie.sign.R;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jie on 2018/9/9.
 */

public class DialogSelector extends Dialog implements DialogMemberAdapter.OnItemClickListener{
    private List<DialogMemberBean> DialogMemberBean = new ArrayList<>();    //选择列表的数据
    private List<DialogMemberBean> DialogMemberBeanselector = new ArrayList<>();
    private Context context;
    private OnSelectorListener cdListener;
    private DialogMemberAdapter mSelectorBranchAdapter;
    private Button btn_cancel;
    private Button btn_ok;
    private RecyclerView rv_selector_branch;
    private int Style; //1 为多选 0 为单选


    public DialogSelector(Context context, List<DialogMemberBean> mSimpleListItemEntity,int style1, OnSelectorListener cdListener) {
        super(context);
        this.context = context;
        this.cdListener = cdListener;
        this.DialogMemberBean = mSimpleListItemEntity;
        this.Style = style1;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.dialog_member);
        this.setCanceledOnTouchOutside(false); // 点击外部会消失
        InitViews();
    }

    private void InitViews() {
        btn_cancel = findViewById(R.id.btn_cancel);
        btn_ok = findViewById(R.id.btn_ok);
        rv_selector_branch = (RecyclerView) findViewById(R.id.rv_selector);
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cdListener.cancel();
            }
        });
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < DialogMemberBean.size(); i++) {
                    if (DialogMemberBean.get(i).isSelector()) {
                        DialogMemberBeanselector.add(DialogMemberBean.get(i));
                    }
                }
                cdListener.getSelectorData(DialogMemberBeanselector);
            }
        });
        LinearLayoutManager layoutmanager = new LinearLayoutManager(getContext());
        rv_selector_branch.setLayoutManager(layoutmanager);
        mSelectorBranchAdapter = new DialogMemberAdapter(DialogMemberBean,Style);
        mSelectorBranchAdapter.setOnItemClickListener(this);
        rv_selector_branch.setAdapter(mSelectorBranchAdapter);
    }

    @Override
    public void onItemClick(int position) {
        if (Style == 1){
            boolean temp = !DialogMemberBean.get(position).isSelector();
            DialogMemberBean.get(position).setSelector(temp);
        }else{
            for (int i = 0; i < DialogMemberBean.size(); i++) {
            if (i == position) {
                if (!DialogMemberBean.get(i).isSelector()) {
                    DialogMemberBean.get(i).setSelector(true);
                }
            } else {
                DialogMemberBean.get(i).setSelector(false);
            }
        }
        }
    }

    public interface OnSelectorListener {

        void getSelectorData(List<DialogMemberBean> trees);

        void cancel();
    }
}

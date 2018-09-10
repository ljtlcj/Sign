package com.example.jie.sign.Utils;

/**
 * Created by jie on 2018/9/9.
 */

import android.content.Context;

import com.example.jie.sign.Bean.DialogMemberBean;
import com.example.jie.sign.CustomView.DialogSelector;
import com.example.jie.sign.R;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by wyy on 2018/1/21.
 */

public class DialogHelper {
    private int style;
    private static final String TAG = DialogHelper.class.getSimpleName();
    private Context context;
    private List<DialogMemberBean> DialogMemberBean = new ArrayList<>();    //选择列表的数据
    private OnHelperSelectorListener onSelectorListener;
    private DialogSelector mDialogSelector;

    private DialogHelper(Context context) {
        this.context = context;
    }

    /**
     * 初始化
     *
     * @param context
     * @return
     */
    public static DialogHelper create(Context context) {
        return new DialogHelper(context);
    }


    /**
     * 设置部门列表的数据
     *
     * @param contactTreeList
     * @return
     */
    public DialogHelper setSelectorData(List<DialogMemberBean> contactTreeList) {
        this.DialogMemberBean = contactTreeList;
        return this;
    }

    /**
     * 设置选择部门监听
     *
     * @param onSelectorListener
     * @return
     */
    public DialogHelper setSelectorListener(OnHelperSelectorListener onSelectorListener) {
        this.onSelectorListener = onSelectorListener;
        return this;
    }

    public DialogHelper setStyle(int style1) {
        this.style = style1;
        return this;
    }

    public void showSelectorDialog() {
        mDialogSelector = new DialogSelector(context, DialogMemberBean, style, new DialogSelector.OnSelectorListener() {
            @Override
            public void getSelectorData(List<DialogMemberBean> trees) {
                mDialogSelector.dismiss();
                onSelectorListener.getSelectorPosition(trees);
            }

            @Override
            public void cancel() {
                mDialogSelector.dismiss();
            }
        });
        mDialogSelector.setCancelable(false);
        mDialogSelector.show();
    }

    public interface OnHelperSelectorListener {
        void getSelectorPosition(List<DialogMemberBean> trees);
    }


}

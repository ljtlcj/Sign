package com.example.jie.sign.Fragment.Main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.jie.sign.BaseTemplate.BaseLazyFragment;
import com.example.jie.sign.CustomView.FastMenuBar;
import com.example.jie.sign.R;
import com.example.jie.sign.View.LoginActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * Created by Diko on 2018/1/13.
 */
public class MineFragment extends BaseLazyFragment implements FastMenuBar.onMenuBarClickListener {

    @BindView(R.id.Ln_new)
    LinearLayout LnNew;
    @BindView(R.id.btn_back)
    Button btnBack;
    Unbinder unbinder;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    public void initViews() {

    }

    @Override
    public void initListener() {
        btnBack.setOnClickListener(this);
        LnNew.setOnClickListener(this);
    }

    @Override
    public void initData() {
        setTitle("我的");
    }

    @Override
    public void processClick(View v) {
        switch (v.getId()){
            case R.id.btn_back:
                startActivity(LoginActivity.class);
                break;
            case R.id.Ln_new:
                Toast.makeText(getActivity(), "当前为最先版本", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

    @Override
    public void onMenuBarClick(FastMenuBar view) {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}

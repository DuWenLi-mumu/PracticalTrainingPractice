package com.example.dwl.myapplication.adapter;

import android.view.View;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.dwl.myapplication.R;

import java.util.List;

/**
 * Author: MR. WU
 * Date: 2019/2/26 16:28
 * Description:
 */

public class BrvahAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public BrvahAdapter(int layoutResId, List data) {
        super(layoutResId, data);
    }


    @Override
    protected void convert(final BaseViewHolder helper, String item) {

        helper.addOnClickListener(R.id.iv_head)
                .addOnClickListener(R.id.tv_title);
        helper.setText(R.id.tv_title,item+"标题");
        helper.setText(R.id.tv_content,"内容");


        helper.getView(R.id.tv_content).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToastUtils.showShort("我点击了个"+helper.getLayoutPosition()+"内容");
            }
        });


        if (helper.getLayoutPosition()==10) {
            helper.setText(R.id.tv_title,"特殊标题");
        }


    }
}

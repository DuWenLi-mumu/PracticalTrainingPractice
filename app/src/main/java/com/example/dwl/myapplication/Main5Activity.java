package com.example.dwl.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.dwl.myapplication.adapter.BrvahAdapter;

import java.util.ArrayList;

/**
 * Author: 18749
 * Description:  brvah的使用
 * 下拉列表下滑的操作
 * 使用框架实现不同的菜单样式
 */
public class Main5Activity extends AppCompatActivity {

    RecyclerView rv;
    BrvahAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        rv = findViewById(R.id.rv);

        ArrayList<String> arrayList = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            arrayList.add(String.valueOf(i));
        }
        adapter = new BrvahAdapter(R.layout.item_list, arrayList);//适配器用来获取每个列表的单行数据

        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                ToastUtils.showShort(String.valueOf(position));
            }
        });

        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {

                switch (view.getId()) {
                    case R.id.iv_head:
                        ToastUtils.showShort("头像" + String.valueOf(position));
                        break;
                    case R.id.tv_title:
                        ToastUtils.showShort("标题" + String.valueOf(position));
                        break;
                }

            }
        });

//        adapter.openLoadAnimation();
        adapter.isFirstOnly(true);
        adapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_LEFT);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);
    }
}

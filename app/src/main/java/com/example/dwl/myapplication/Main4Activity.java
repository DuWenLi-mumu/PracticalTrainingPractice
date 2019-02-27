package com.example.dwl.myapplication;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.example.dwl.myapplication.adapter.MyRecAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Author: MR. WU
 * Description:  recy的使用
 */
public class Main4Activity extends AppCompatActivity {

    RecyclerView rv;
    SwipeRefreshLayout srf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        rv = findViewById(R.id.rv);
        srf = findViewById(R.id.srf);
        srf.setColorSchemeColors(getResources().getColor(R.color.red));
        ArrayList list = new ArrayList();
        for (int i = 0; i < 100; i++) {
            list.add(String.valueOf(i));

        }

        MyRecAdapter adapter = new MyRecAdapter(list);

        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);


        srf.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {



                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        // 启动刷新的控件
                        srf.post(new Runnable() {
                            @Override
                            public void run() {
                                // 设置是否开始刷新,true为刷新，false为停止刷新
                                srf.setRefreshing(false);
                            }
                        });

                    }
                }).start();
            }
        });

    }

}

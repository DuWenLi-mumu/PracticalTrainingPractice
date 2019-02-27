package com.example.dwl.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.blankj.utilcode.util.ToastUtils;

import java.util.ArrayList;

public class Main3Activity extends AppCompatActivity {

    ListView lv;
    ArrayList list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        lv = findViewById(R.id.lv);

        list = new ArrayList();
        for (int i = 0; i < 100; i++) {
            list.add(String.valueOf(i));
        }

        //设置适配器
        lv.setAdapter(new MyAdapter());
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ToastUtils.showShort(i+"");
            }
        });
    }

    private class  MyAdapter extends BaseAdapter {

        //这个列表有多少条数据
        @Override
        public int getCount() {
            return list.size();
        }

        //返回构造函数传进来的里里面的某一条数据
        @Override
        public Object getItem(int i) {
            return list.get(i);
        }
        //第几行列表
        @Override
        public long getItemId(int i) {
            return i;
        }


        //找到相对的布局文件
        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View v = View.inflate(Main3Activity.this, R.layout.item_list, null);
            return v;
        }
    }

}

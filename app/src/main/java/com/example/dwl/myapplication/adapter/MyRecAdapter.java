package com.example.dwl.myapplication.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.example.dwl.myapplication.R;

import java.util.ArrayList;

/**
 * Author: MR. WU
 * Date: 2019/2/26 15:12
 * Description: 自定义的rec的适配器
 */

public class MyRecAdapter extends RecyclerView.Adapter<MyRecAdapter.VH> {

    private ArrayList data;

    public MyRecAdapter(ArrayList data) {
        this.data = data;
    }

    //跟布局文件相对应
    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        VH vh = new VH(v);
        vh.lin_rec = v.findViewById(R.id.lin_rec);
        vh.title = v.findViewById(R.id.tv_title);
        vh.content = v.findViewById(R.id.tv_content);
        vh.head = v.findViewById(R.id.iv_head);

        return vh;
    }

    //对每个控件进行操作
    @Override
    public void onBindViewHolder(VH holder, final int position) {

        switch (position % 3) {

            case 0:
                holder.title.setText("这个是第一个行数据的标题");
                holder.content.setText("这个是第一个行数据的内容");
                holder.head.setImageResource(R.drawable.fengyi);
                break;
            case 1:
                holder.title.setText("这个是第2个行数据的标题");
                holder.content.setText("这个是第2个行数据的内容");
                holder.head.setImageResource(R.drawable.maozi);
                break;

            case 2:
                holder.title.setText("这个是第3个行数据的标题");
                holder.content.setText("这个是第3个行数据的内容");
                holder.head.setImageResource(R.drawable.fengyi);
                break;

        }


        holder.lin_rec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToastUtils.showShort(position + "recy");
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class VH extends RecyclerView.ViewHolder {
        LinearLayout lin_rec;
        TextView title;
        TextView content;
        ImageView head;

        public VH(View itemView) {
            super(itemView);
        }
    }
}

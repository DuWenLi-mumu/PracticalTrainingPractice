package com.example.dwl.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.example.dwl.myapplication.bean.LoginBean;
import com.example.dwl.myapplication.bean.UserBean;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Response;

public class Main6Activity extends AppCompatActivity {

    @BindView(R.id.get)
    Button mGet;
    @BindView(R.id.post)
    Button mPost;
    @BindView(R.id.iv_head)
    ImageView mIvHead;
    @BindView(R.id.name)
    TextView mName;
    @BindView(R.id.email)
    TextView mEmail;
    @BindView(R.id.addr)
    TextView mAddr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.get, R.id.post})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.get: //get方法在网址栏上面会显示用户输入的数据，因而不安全，一般都用的是post
                String url = "http://mutualaid.scgbgx.com/mutualAid/api/basic/login";
                OkGo.get(url)     // 请求方式和请求url
                        .execute(new StringCallback() {

                            @Override
                            public void onSuccess(String s, Call call, Response response) {

                                LogUtils.iTag("onSuccess", s);//将请求到的数据存到s中

                                Gson gson = new Gson();//将获取的json数据转化为对象
                                UserBean bean = gson.fromJson(s, UserBean.class);//将json转化为UserBean这个类的形式，然后返回一个对象，放入bean中

                                ToastUtils.showShort(bean.name);//在界面显示这个人的名字，这个功能可以不要

                                Glide.with(Main6Activity.this)//加载图片并且显示
                                        .load(bean.avatar)
                                        .placeholder(R.mipmap.ic_launcher)
                                        .error(R.mipmap.ic_launcher)
                                        .crossFade()
                                        .into(mIvHead);

                                mName.setText(bean.name);
                                mAddr.setText(bean.addr);
                                mEmail.setText(bean.email);
                            }

                        });
                break;
            case R.id.post:
                String postUrl = "";
                OkGo.post(postUrl)
                        .params("phone", "15528261926")
                        .params("code", "111")
                        .execute(new StringCallback() {
                            @Override
                            public void onSuccess(String s, Call call, Response response) {
                                LoginBean o = new Gson().fromJson(s, LoginBean.class);
                                ToastUtils.showShort(o.data.token);

                            }
                        });

                break;


        }
    }


}

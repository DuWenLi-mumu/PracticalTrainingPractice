package com.example.dwl.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.blankj.utilcode.util.EmptyUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.RegexUtils;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;

public class MainActivity extends AppCompatActivity {

    EditText et_login;
    EditText et_pass;
    CheckBox cb;
    boolean flag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnReg = findViewById(R.id.btn_reg);
        et_login = findViewById(R.id.et_login);
        et_pass = findViewById(R.id.et_pass);
        cb = findViewById(R.id.cb);

        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                flag = b;
            }
        });

        if (EmptyUtils.isNotEmpty(SPUtils.getInstance().getString("str_login"))) {
            cb.setChecked(true);
        } else {
            cb.setChecked(false);
        }

        //记住密码的操作
        et_login.setText(SPUtils.getInstance().getString("str_login"));
        et_pass.setText(SPUtils.getInstance().getString("str_pass"));


        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "点击了注册按钮", Toast.LENGTH_SHORT).show();

                ToastUtils.showShort("用的三方库的toast");

                LogUtils.i("用三方库的log打出来的日志");

            }
        });

    }

    /**
     * 登录按钮的点击事件
     * @param view
     */
    public void login(View view) {
        //获取输入框中的数据，转换成string形式，去掉空格
        String str_login = et_login.getText().toString().trim();
        String str_pass = et_pass.getText().toString().trim();

        //调用第三方库正则表达式来判断手机号是否正确
        if (!RegexUtils.isMobileSimple(str_login)) {
            ToastUtils.showShort("请输入正确的手机号码");
            return;
        }

        if (flag) {
            //选中状态我们需要把et里面的内容存入sp

            SPUtils.getInstance().put("str_login", str_login);
            SPUtils.getInstance().put("str_pass", str_pass);


        } else {
            //未选中需要清除
            SPUtils.getInstance().remove("str_login");
            SPUtils.getInstance().remove("str_pass");
        }

        Intent intent = new Intent(this, Main2Activity.class);
        intent.putExtra("str_login", str_login);
        intent.putExtra("str_pass", str_pass);

        startActivity(intent);


    }
}

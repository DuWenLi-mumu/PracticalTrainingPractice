package com.example.dwl.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        TextView tv_login = findViewById(R.id.login);
        TextView tv_pass = findViewById(R.id.pass);


        String str_login = getIntent().getStringExtra("str_login");
        String str_pass = getIntent().getStringExtra("str_pass");


        tv_login.setText(str_login);
        tv_pass.setText(str_pass);
    }

}

package com.futurenavi.basic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.futurenavi.libbasic.API;

public class MainAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);
        TextView tv = (TextView) findViewById(R.id.tv);
        tv.setText(API.getInfo());
    }
}

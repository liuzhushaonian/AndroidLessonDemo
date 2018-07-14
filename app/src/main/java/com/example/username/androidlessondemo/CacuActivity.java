package com.example.username.androidlessondemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CacuActivity extends AppCompatActivity {

    private TextView info1,info2,info3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cacu);

        getComponent();

        initInfos();

        setTitle("计算标准体重");
    }


    private void getComponent(){

        info1=findViewById(R.id.textView10);
        info2=findViewById(R.id.textView11);
        info3=findViewById(R.id.textView12);

    }

    private void initInfos(){

        Intent intent=getIntent();

        Bundle bundle=intent.getBundleExtra("bundle");

        float height=bundle.getFloat("height");

        float weight=bundle.getFloat("weight");

        String sex=bundle.getString("sex");

        String s1="您是一位"+sex;

        String s2="您的身高是"+height+"厘米";

        String s3="您的标准体重是"+weight+"公斤";

        info1.setText(s1);
        info2.setText(s2);
        info3.setText(s3);

    }


}

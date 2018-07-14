package com.example.username.androidlessondemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;

public class Demo3Activity extends AppCompatActivity {

    private TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo3);

        getComponent();

        initTab();

        setTitle("ActionBar的Tab导航");
    }

    private void getComponent(){

        tabHost=findViewById(R.id.tabhost);

    }

    private void initTab(){
        tabHost.setup();

        tabHost.addTab(tabHost.newTabSpec("第一页").setContent(R.id.tab1).setIndicator("第一页"));
        tabHost.addTab(tabHost.newTabSpec("第二页").setContent(R.id.tab2).setIndicator("第二页"));
        tabHost.addTab(tabHost.newTabSpec("第三页").setContent(R.id.tab3).setIndicator("第三页"));



    }

}

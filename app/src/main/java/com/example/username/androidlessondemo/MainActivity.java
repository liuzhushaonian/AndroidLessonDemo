package com.example.username.androidlessondemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button demo1,demo2,demo3,demo4,demo5,demo6,demo7,demo8;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getComponent();
        setTitle("Android作业");
    }

    /**
     * 获取Layout里的控件并绑定
     * 设置点击事件
     */
    private void getComponent(){

        //获取控件
        demo1=findViewById(R.id.demo1);
        demo2=findViewById(R.id.demo2);
        demo3=findViewById(R.id.demo3);
        demo4=findViewById(R.id.demo4);
        demo5=findViewById(R.id.demo5);
        demo6=findViewById(R.id.demo6);
        demo7=findViewById(R.id.demo7);
        demo8=findViewById(R.id.demo8);

        //绑定事件
        demo1.setOnClickListener(this);
        demo2.setOnClickListener(this);
        demo3.setOnClickListener(this);
        demo4.setOnClickListener(this);
        demo5.setOnClickListener(this);
        demo6.setOnClickListener(this);
        demo7.setOnClickListener(this);
        demo8.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {




        switch (v.getId()){

            case R.id.demo1:

                Intent intent=new Intent(MainActivity.this,Demo1Activity.class);

                startActivity(intent);

                break;

            case R.id.demo2:

                Intent intent2=new Intent(MainActivity.this,Demo2Activity.class);

                startActivity(intent2);

                break;
            case R.id.demo3:

                Intent intent3=new Intent(MainActivity.this,Demo3Activity.class);

                startActivity(intent3);


                break;
            case R.id.demo4:

                Intent intent4=new Intent(MainActivity.this,Demo4Activity.class);

                startActivity(intent4);

                break;
            case R.id.demo5:

                Intent intent5=new Intent(MainActivity.this,Demo5Activity.class);

                startActivity(intent5);

                break;
            case R.id.demo6:

                Intent intent6=new Intent(MainActivity.this,Demo6Activity.class);

                startActivity(intent6);


                break;
            case R.id.demo7:

                Intent intent7=new Intent(MainActivity.this,Demo7Activity.class);

                startActivity(intent7);

                break;
            case R.id.demo8:

                Intent intent8=new Intent(MainActivity.this,Demo8Activity.class);

                startActivity(intent8);

                break;



        }


    }
}

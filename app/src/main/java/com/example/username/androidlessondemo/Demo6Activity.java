package com.example.username.androidlessondemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Demo6Activity extends AppCompatActivity {

    private ImageView imageView;

    private List<String> files;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo6);
        imageView=findViewById(R.id.ad_image);

        initImage();

        startLun();

        setTitle("Handler2秒显示广告");
    }

    private void initImage(){

        files=new ArrayList<>();

        try {
            String s[] =getAssets().list("ad");

            files.addAll(Arrays.asList(s));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void startLun(){

        new Thread(){

            @Override
            public void run() {
//                super.run();

                try {

                    while (true) {
                        sleep(2000);

                        handler.sendEmptyMessage(0);

                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }.start();

    }


    Handler handler=new Handler(Looper.getMainLooper()){

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            switch (msg.what){

                case 0:

                    Random random=new Random();

                    int p=random.nextInt(files.size());

                    String path="ad/"+files.get(p);

                    try {
                        Bitmap bitmap= BitmapFactory.decodeStream(getAssets().open(path));

                        if (bitmap!=null){

                            imageView.setImageBitmap(bitmap);
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    break;




            }




        }
    };

}

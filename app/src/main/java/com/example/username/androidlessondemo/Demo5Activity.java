package com.example.username.androidlessondemo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;

public class Demo5Activity extends AppCompatActivity {


    private Button button;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo5);

        getComponent();

        event();

        setTitle("注册与头像选择");
    }

    private void getComponent(){

        button=findViewById(R.id.button3);

        imageView=findViewById(R.id.imageView);

    }

    private void event(){

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Demo5Activity.this,ImageActivity.class);
                startActivityForResult(intent,1000);

            }
        });


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        switch (requestCode){


            case 1000:

                if (resultCode!=2000){
                    return;
                }

                if (data==null){
                    return;
                }

                String s=data.getStringExtra("image");

                try {



                    Bitmap bitmap=BitmapFactory.decodeStream(getAssets().open("image/"+s));

                    if (bitmap!=null){
                        imageView.setImageBitmap(bitmap);
                    }


                } catch (IOException e) {
                    e.printStackTrace();
                }

                break;

            default:

                super.onActivityResult(requestCode, resultCode, data);

                break;

        }


    }
}

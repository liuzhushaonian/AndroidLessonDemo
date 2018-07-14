package com.example.username.androidlessondemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class Demo4Activity extends AppCompatActivity {

    private RadioGroup radioGroup;

    private EditText editText;

    private Button button;

    private boolean isMan=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo4);

        getComponent();

        event();

        setTitle("计算标准体重");
    }

    private void getComponent(){

        radioGroup=findViewById(R.id.radioGroup);

        editText=findViewById(R.id.editText6);

        button=findViewById(R.id.button2);

    }


    private void event(){

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s=editText.getText().toString();

                if (TextUtils.isEmpty(s)){
                    return;
                }

                float height=Float.parseFloat(s);
                Bundle bundle=new Bundle();

                float weight=0;

                if (isMan) {
                    weight = (float) ((height-80)*0.7);
                    bundle.putString("sex","男士");
                }else {

                    weight= (float) ((height-70)*0.6);
                    bundle.putString("sex","女士");

                }

                if (weight<=0){
                    return;
                }

                Intent intent=new Intent(Demo4Activity.this,CacuActivity.class);

                bundle.putFloat("height",height);

                bundle.putFloat("weight",weight);

                intent.putExtra("bundle",bundle);

                startActivity(intent);


            }
        });


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId){

                    case R.id.male:

                        isMan=true;

                        break;


                    case R.id.female:

                        isMan=false;
                        break;

                }

            }
        });


    }


}

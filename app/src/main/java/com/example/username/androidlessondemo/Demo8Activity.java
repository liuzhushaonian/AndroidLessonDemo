package com.example.username.androidlessondemo;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Demo8Activity extends AppCompatActivity {


    private BoundService boundService;
    boolean isBound=false;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo8);
        button=findViewById(R.id.show);

        click();

        setTitle("当前时间");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Intent intent=new Intent(this,BoundService.class);

        bindService(intent,mConnection, Context.BIND_AUTO_CREATE);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (isBound){
            unbindService(mConnection);
            isBound=false;
        }

    }

    /** Defines callbacks for service binding, passed to bindService() */
    private ServiceConnection mConnection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName className,
                                       IBinder service) {
            // We've bound to LocalService, cast the IBinder and get LocalService instance
            BoundService.LocalBind binder = (BoundService.LocalBind) service;
            boundService = binder.getService();
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName arg0) {
            isBound = false;
        }
    };


    private void click(){

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Demo8Activity.this, ""+boundService.showTime(), Toast.LENGTH_SHORT).show();
            }
        });


    }

}

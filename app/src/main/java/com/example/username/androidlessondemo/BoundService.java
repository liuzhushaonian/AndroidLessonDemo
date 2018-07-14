package com.example.username.androidlessondemo;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class BoundService extends Service {

    private final IBinder binder=new LocalBind();



    public BoundService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
//        throw new UnsupportedOperationException("Not yet implemented");


        return binder;
    }


    class LocalBind extends Binder{

        BoundService getService(){
            return BoundService.this;
        }

    }


    public String showTime(){

        long time=System.currentTimeMillis();

        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);

        Date date=new Date(time);

        return simpleDateFormat.format(date);

    }


}

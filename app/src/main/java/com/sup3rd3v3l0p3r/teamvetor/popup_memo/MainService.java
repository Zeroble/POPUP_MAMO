package com.sup3rd3v3l0p3r.teamvetor.popup_memo;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.IBinder;

public class MainService extends Service {
    @Override
    public void onCreate() {
        SharedPreferences String = getSharedPreferences("String", MODE_PRIVATE);
        if(String.getInt("autoStart",1)==0)
            onDestroy();
        IntentFilter intentFilter=new IntentFilter(Intent.ACTION_SCREEN_ON);
        intentFilter.addAction(Intent.ACTION_SCREEN_OFF);
        BroadcastReceiver myReceiver = new Broadcast();
        registerReceiver(myReceiver,intentFilter);
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        SharedPreferences String = getSharedPreferences("String", MODE_PRIVATE);
        if(String.getInt("autoStart",1)==0)
            onDestroy();

        else if(intent == null){
            if(String.getInt("autoStart",1)==0)
                onDestroy();
            IntentFilter intentFilter=new IntentFilter(Intent.ACTION_SCREEN_ON);
            BroadcastReceiver myReceiver = new Broadcast();
            registerReceiver(myReceiver,intentFilter);
        }
        return START_STICKY;
    }
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        stopSelf();
        stopForeground(true);
        super.onDestroy();
    }
}
package com.sup3rd3v3l0p3r.teamvetor.popup_memo;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.util.Log;

public class MainService extends Service {
    @Override
    public void onCreate() {
        Log.i("oncreat","BROADCASTRECEVIER등록");
        IntentFilter intentFilter=new IntentFilter(Intent.ACTION_SCREEN_ON);
        intentFilter.addAction(Intent.ACTION_SCREEN_OFF);
        BroadcastReceiver myReceiver = new Broadcast();
        registerReceiver(myReceiver,intentFilter);
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("ㄴㅇㄹ","쁘쁘쁘ㅡㅃ");
        if(intent == null){
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
        super.onDestroy();
    }
}
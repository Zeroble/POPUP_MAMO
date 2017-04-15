package com.sup3rd3v3l0p3r.teamvetor.popup_memo;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    BroadcastReceiver myReceiver = new Broadcast();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent Service = new Intent(this,MainService.class);
        startService(Service);
        Log.i("아아 마이크테스트","서비스 실해됨");
    }
}

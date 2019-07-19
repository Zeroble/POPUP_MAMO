package com.sup3rd3v3l0p3r.teamvetor.popup_memo;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by dlals on 2017-04-15.
 */

public class Broadcast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (Intent.ACTION_SCREEN_ON == intent.getAction()) {// 화면 켜짐
            Intent Show = new Intent(context,ShowMessage.class);
            PendingIntent pendingIntent = PendingIntent.getActivities(context,0, new Intent[]{Show},0);
            try {
                pendingIntent.send();
            } catch (PendingIntent.CanceledException e) {
                e.printStackTrace();
            }
        }
        if (Intent.ACTION_SCREEN_OFF == intent.getAction()) {// 화면 꺼짐
            Log.i("아아 마이크테스트","화면 꺼짐");

        }

        if(Intent.ACTION_BOOT_COMPLETED == intent.getAction()){//
            Intent Service = new Intent(context, MainService.class);
            context.startService(Service);
        }
    }
}

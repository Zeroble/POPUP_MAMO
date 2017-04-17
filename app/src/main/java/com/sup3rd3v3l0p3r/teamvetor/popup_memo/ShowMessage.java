package com.sup3rd3v3l0p3r.teamvetor.popup_memo;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by dlals on 2017-04-15.
 */

public class ShowMessage extends AppCompatActivity{
    int times=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message);
        String text;
        TextView textView = (TextView) findViewById(R.id.textView);
        SharedPreferences String = getSharedPreferences("String", MODE_PRIVATE);
        text = String.getString("text","Nothing to show");
        textView.setText(text);
    }
    public void Clear(View v){
        SharedPreferences String = getSharedPreferences("String", MODE_PRIVATE);
        if(times == String.getInt("times",0))
            finish();
        else Toast.makeText(getApplicationContext(),String.getInt("times",-1)-times+" 회 더 눌러주세요.",Toast.LENGTH_SHORT).show();
        times++;
    }
    @Override
    public void onBackPressed(){
        Toast.makeText(getApplicationContext(),"확인 버튼을 눌러 종료해주세요.",Toast.LENGTH_SHORT).show();
    }
}

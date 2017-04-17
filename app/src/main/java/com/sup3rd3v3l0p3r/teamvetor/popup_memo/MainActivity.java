package com.sup3rd3v3l0p3r.teamvetor.popup_memo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editTimes = (EditText) findViewById(R.id.editTimes);
        EditText editText = (EditText) findViewById(R.id.editText);
        SharedPreferences String = getSharedPreferences("String", MODE_PRIVATE);


        if(String.getInt("autoStart",1)==0){
            Intent Service = new Intent(this, MainService.class);
            stopService(Service);
        }

        editText.setText(String.getString("text","none"));
        editTimes.setText(""+String.getInt("times",0));
        editTimes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"메모를 종료할때 클릭할 버튼을 클릭할 횟수를 입력해 주세요.",Toast.LENGTH_LONG).show();
            }
        });
    }

    public void OK(View v) {
        SharedPreferences String = getSharedPreferences("String", MODE_PRIVATE);
        SharedPreferences.Editor editor = String.edit();
        EditText editText = (EditText) findViewById(R.id.editText);
        EditText editTimes = (EditText) findViewById(R.id.editTimes);

        Toast.makeText(getApplicationContext(), "저장되었습니다.", Toast.LENGTH_LONG).show();
        editor.putString("text", editText.getText().toString());
        if(editTimes.getText().toString().equals("")) Toast.makeText(getApplicationContext(),"횟수를 입력하여 주세요.",Toast.LENGTH_LONG).show();
        else {
            editor.putInt("times", Integer.parseInt(editTimes.getText().toString()));
            editor.putInt("autoStart", 1);
            editor.commit();
            Intent Service = new Intent(this, MainService.class);
            startService(Service);
            Log.i("아아 마이크테스트", "서비스 실행됨");
        }

    }

    public void startService(View v) {
        SharedPreferences String = getSharedPreferences("String", MODE_PRIVATE);
        SharedPreferences.Editor editor = String.edit();

        Intent Service = new Intent(this, MainService.class);
        startService(Service);

        Toast.makeText(getApplicationContext(),"서비스를 시작하였습니다.",Toast.LENGTH_SHORT).show();
        editor.putInt("autoStart", 1);
        editor.commit();
        Log.i("아아 마이크테스트", "서비스 실행됨");
    }

    public void stopService(View v) {
        SharedPreferences String = getSharedPreferences("String", MODE_PRIVATE);
        SharedPreferences.Editor editor = String.edit();
        editor.putInt("autoStart",0);
        editor.commit();
        Intent Service = new Intent(this, MainService.class);
        stopService(Service);
        Toast.makeText(getApplicationContext(),"서비스를 중지하였습니다.",Toast.LENGTH_SHORT).show();
        Log.i("아아 마이크테스트", "서비스 종료됨    "+String.getInt("autoStart",-1));
    }

}

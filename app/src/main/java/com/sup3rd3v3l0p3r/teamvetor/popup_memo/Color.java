package com.sup3rd3v3l0p3r.teamvetor.popup_memo;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.larswerkman.holocolorpicker.ColorPicker;
import com.larswerkman.holocolorpicker.OpacityBar;
import com.larswerkman.holocolorpicker.SVBar;
import com.larswerkman.holocolorpicker.SaturationBar;
import com.larswerkman.holocolorpicker.ValueBar;

import static com.sup3rd3v3l0p3r.teamvetor.popup_memo.R.id.opacitybar;

/**
 * Created by dlals on 2017-04-18.
 */

public class Color extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pick);
        TextView textView = (TextView) findViewById(R.id.putColor);
        ColorPicker picker = (ColorPicker) findViewById(R.id.picker);
        SVBar svBar = (SVBar) findViewById(R.id.svbar);
        OpacityBar opacityBar = (OpacityBar) findViewById(opacitybar);
        SaturationBar saturationBar = (SaturationBar) findViewById(R.id.saturationbar);
        ValueBar valueBar = (ValueBar) findViewById(R.id.valuebar);

        picker.addSVBar(svBar);
        picker.addOpacityBar(opacityBar);
        picker.addSaturationBar(saturationBar);
        picker.addValueBar(valueBar);

// adds listener to the colorpicker which is implemented
//in the activity
        picker.setOnColorChangedListener(new ColorPicker.OnColorChangedListener() {
            @Override
            public void onColorChanged(int color) {

            }
        });

//to turn of showing the old color
        picker.setShowOldCenterColor(false);

//adding onChangeListeners to bars
        opacityBar.setOnOpacityChangedListener(new OpacityBar.OnOpacityChangedListener() {
            @Override
            public void onOpacityChanged(int opacity) {

            }
        });
        valueBar.setOnValueChangedListener(new ValueBar.OnValueChangedListener() {
            @Override
            public void onValueChanged(int value) {

            }
        });
        saturationBar.setOnSaturationChangedListener(new SaturationBar.OnSaturationChangedListener() {
            @Override
            public void onSaturationChanged(int saturation) {

            }
        });

//To set the old selected color u can do it like this
        picker.setOldCenterColor(picker.getColor());

        SharedPreferences save = getSharedPreferences("String", MODE_PRIVATE);
        picker.setColor(save.getInt("color",0));
        textView.setBackgroundColor(save.getInt("color",0));
    }
    public void pickColor(View v){
        ColorPicker picker = (ColorPicker) findViewById(R.id.picker);
        SharedPreferences save = getSharedPreferences("String", MODE_PRIVATE);
        SharedPreferences.Editor editor = save.edit();

        //To get the color
        editor.putInt("color",picker.getColor());
        editor.commit();

        TextView textView = (TextView) findViewById(R.id.putColor);
        textView.setBackgroundColor(picker.getColor());
        finish();
    }
}

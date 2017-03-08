package com.rhys.logol.seng310phase3;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class Settings extends AppCompatActivity implements View.OnClickListener {
    Button customize;
    Button logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        //hide action bar
        getSupportActionBar().hide();

        final Drawable settings_img_pressed = getResources().getDrawable(R.drawable.settings_button_pressed);
        final Drawable settings_img = getResources().getDrawable(R.drawable.settings_button);

        final Button xButton = (Button) findViewById(R.id.settings_button);
        customize = (Button) findViewById(R.id.customize);
        logout = (Button) findViewById(R.id.logout);

        CheckBox class_mode = (CheckBox) findViewById(R.id.class_mode);

        xButton.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int i = v.getId();
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    xButton.setBackground(settings_img_pressed);
                    return true;
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    xButton.setBackground(settings_img);
                    if(i == R.id.settings_button){
                        finish();
                    }
                    return true;
                }
                return false;
            }
        });

        customize.setOnClickListener(this);
        logout.setOnClickListener(this);

    }
    public void onCheckboxClicked(View view) {
    }

    @Override
    public void onClick(View view) {
        int i = view.getId();
        if(i == R.id.customize){
            startActivity(new Intent(this,CustomizeMenu.class));
        }
        if(i == R.id.logout){
            startActivity(new Intent(this,LoginActivity.class));
            finish();
        }
    }
}
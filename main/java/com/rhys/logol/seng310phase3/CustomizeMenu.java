package com.rhys.logol.seng310phase3;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class CustomizeMenu extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customizemenu);

        final Drawable settings_img_pressed = getResources().getDrawable(R.drawable.settings_button_pressed);
        final Drawable settings_img = getResources().getDrawable(R.drawable.settings_button);

        final Button xButton = (Button) findViewById(R.id.closebutton);

        getSupportActionBar().hide();

        xButton.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    xButton.setBackground(settings_img_pressed);
                    return true;
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    xButton.setBackground(settings_img);
                    finish();
                    return true;
                }
                return false;
            }
        });
    }


}
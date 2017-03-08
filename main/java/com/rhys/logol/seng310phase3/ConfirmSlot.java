package com.rhys.logol.seng310phase3;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ConfirmSlot extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_slot);

        //hide action bar
        getSupportActionBar().hide();

        Drawable plus_img_pressed = getResources().getDrawable(R.drawable.plus_button_pressed);
        Drawable plus_img = getResources().getDrawable(R.drawable.plus_button);

        Drawable settings_img_pressed = getResources().getDrawable(R.drawable.settings_button_pressed);
        Drawable settings_img = getResources().getDrawable(R.drawable.settings_button);

        Button userIdButton = (Button) findViewById(R.id.user_id_button);

        Button settingsButton = (Button) findViewById(R.id.settings_button);
        buttonFeedback(settingsButton, settings_img_pressed, settings_img);


        Button confirmTimeButton = (Button) findViewById(R.id.confirm_time_button);
        buttonFeedback(confirmTimeButton, plus_img_pressed, plus_img);

        Button backToEventsButton = (Button) findViewById(R.id.back_to_events_button);
        buttonFeedback(backToEventsButton, plus_img_pressed, plus_img);

    }

    public void buttonFeedback(final Button button, final Drawable image_pressed, final Drawable image){

        button.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int i = v.getId();
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    button.setBackground(image_pressed);
                    return true;
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    if(i == R.id.settings_button){
                        button.setBackground(image);
                        startActivity(new Intent(ConfirmSlot.this,Settings.class));
                    }if(i == R.id.confirm_time_button){
                        button.setBackground(image);
                        Toast.makeText(ConfirmSlot.this, "Slot Confirmed.", Toast.LENGTH_SHORT).show();
                    }if(i == R.id.settings_button){
                        button.setBackground(image);
                        finish();
                    }
                    return true;
                }
                return false;
            }
        });
    }
}
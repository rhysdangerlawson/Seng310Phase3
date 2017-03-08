package com.rhys.logol.seng310phase3;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.Spinner;

public class AddEvent extends AppCompatActivity implements View.OnClickListener {
    Button backButton, plusButton,addButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);

        getSupportActionBar().hide();

        plusButton = (Button) findViewById(R.id.plus_button);
        Drawable plus_img_pressed = getResources().getDrawable(R.drawable.plus_button_pressed);
        Drawable plus_img = getResources().getDrawable(R.drawable.plus_button);
        buttonFeedback(plusButton, plus_img_pressed, plus_img);

        DatePicker DatePicker = (DatePicker)findViewById(R.id.date_picker); // initiate a date picker

        DatePicker.setSpinnersShown(true); // set false value for the spinner shown function


        //start
        Spinner startSpinner = (Spinner) findViewById(R.id.start_spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapt1 = ArrayAdapter.createFromResource(this,
                R.array.hours_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapt1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        startSpinner.setAdapter(adapt1);

        //end spinner
        Spinner endSpinner = (Spinner) findViewById(R.id.end_spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapt2 = ArrayAdapter.createFromResource(this,
                R.array.hours_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapt2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        endSpinner.setAdapter(adapt2);


//categories spinner
        Spinner spinner = (Spinner) findViewById(R.id.categories_spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.categories_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        CheckBox checkBox = (CheckBox) findViewById(R.id.repeat_weekly_cb);

//Notify me spinner
        Spinner notifyMe = (Spinner) findViewById(R.id.notify_spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.notify_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        notifyMe.setAdapter(adapter2);

        addButton = (Button) findViewById(R.id.add_event_button);
        backButton = (Button) findViewById(R.id.backbutton);

        backButton.setOnClickListener(this);
        addButton.setOnClickListener(this);
    }

    public void onCheckboxClicked(View view) {
    }

    public void onRadioButtonClicked(View view) {
    }

    public void buttonFeedback(final Button button, final Drawable image_pressed, final Drawable image){

        button.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {

                    button.setBackground(image_pressed);
                    return true;
                } else if (event.getAction() == MotionEvent.ACTION_UP) {

                    button.setBackground(image);
                    return true;
                }
                return false;
            }
        });
    }

    @Override
    public void onClick(View view) {
        int i = view.getId();
        if(i == R.id.add_event_button){
            startActivity(new Intent(this,ConfirmSlot.class));
        }if(i == R.id.backbutton){
            finish();
        }
    }
}
package com.rhys.logol.seng310phase3;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

class WeekActivity extends AppCompatActivity implements View.OnClickListener {
    ImageButton weekView;
    Button week1;
    Button week2;
    Button week3;
    Button week4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week);

        getSupportActionBar().hide();

        Button settings = (Button) findViewById(R.id.settings_button);
        Button addEvent = (Button) findViewById(R.id.confirm_time_button);
        Button graph = (Button) findViewById(R.id.graph);
        Button displayError = (Button) findViewById(R.id.display_error);
        Button calenderView = (Button) findViewById(R.id.calender_view);
        Button profilePic = (Button) findViewById(R.id.user_id_button);
        week1 = (Button) findViewById(R.id.week1);
        week2 = (Button) findViewById(R.id.week2);
        week3 = (Button) findViewById(R.id.week3);
        week4 = (Button) findViewById(R.id.week4);

        weekView = (ImageButton) findViewById(R.id.weekView);
        weekView.setVisibility(View.INVISIBLE);

        TextView userID = (TextView) findViewById(R.id.textView3);

        userID.setText("UserId");

        settings.setOnClickListener(WeekActivity.this);
        addEvent.setOnClickListener(WeekActivity.this);
        graph.setOnClickListener(WeekActivity.this);
        displayError.setOnClickListener(WeekActivity.this);
        calenderView.setOnClickListener(WeekActivity.this);
        week2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int i = view.getId();
        if(i == R.id.settings_button){
            startActivity(new Intent(this,Settings.class));
        }if(i == R.id.confirm_time_button){
            startActivity(new Intent(this,AddEvent.class));
        }if(i == R.id.graph){
            startActivity(new Intent(this,GraphPage.class));
        }if(i == R.id.display_error){
            displayError();
        }if(i == R.id.calender_view){
            finish();
        }if(i == R.id.week2){
            displayWeekImage();
        }if(i == R.id.weekView){
            displayButtons();
        }
    }

    private void displayButtons(){
        weekView.setVisibility(View.GONE);
        week1.setVisibility(View.VISIBLE);
        week2.setVisibility(View.VISIBLE);
        week3.setVisibility(View.VISIBLE);
        week4.setVisibility(View.VISIBLE);
    }

    private void displayWeekImage() {
        weekView.setVisibility(View.VISIBLE);
        week1.setVisibility(View.INVISIBLE);
        week2.setVisibility(View.INVISIBLE);
        week3.setVisibility(View.INVISIBLE);
        week4.setVisibility(View.INVISIBLE);
    }

    public void displayError(){
        // Create custom dialog object
        final Dialog dialog = new Dialog(WeekActivity.this);
        // Include dialog.xml file
        dialog.setContentView(R.layout.error_dialog);
        // Set dialog title
        dialog.setTitle("Custom Dialog");

        Button mergeEvent = (Button) dialog.findViewById(R.id.merge_event);
        Button replace = (Button) dialog.findViewById(R.id.replace_button);

        mergeEvent.setOnClickListener(this);
        replace.setOnClickListener(this);

        dialog.show();
    }
}

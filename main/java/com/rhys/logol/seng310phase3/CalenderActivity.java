package com.rhys.logol.seng310phase3;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CalenderActivity extends AppCompatActivity implements View.OnClickListener {
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);

        getSupportActionBar().hide();

        Button settings = (Button) findViewById(R.id.settings_button);
        Button addEvent = (Button) findViewById(R.id.confirm_time_button);
        Button graph = (Button) findViewById(R.id.graph);
        Button displayError = (Button) findViewById(R.id.display_error);
        Button weekView = (Button) findViewById(R.id.week_view);

        TextView userID = (TextView) findViewById(R.id.textView3);

        Button profilePic = (Button) findViewById(R.id.user_id_button);

        userID.setText("UserId");

        settings.setOnClickListener(CalenderActivity.this);
        addEvent.setOnClickListener(CalenderActivity.this);
        graph.setOnClickListener(CalenderActivity.this);
        displayError.setOnClickListener(CalenderActivity.this);
        weekView.setOnClickListener(CalenderActivity.this);
    }

    @Override public void onClick(View view) {
        int i = view.getId();
        if(i == R.id.settings_button){
            startActivity(new Intent(this,Settings.class));
        }if(i == R.id.confirm_time_button){
            startActivity(new Intent(this,AddEvent.class));
        }if(i == R.id.graph){
            startActivity(new Intent(this,GraphPage.class));
        }if(i == R.id.display_error){
            // Display Error dialog
            displayError();
        }if(i == R.id.merge_event){
            Toast.makeText(this, "Successfully Merged Event.", Toast.LENGTH_SHORT).show();
        }if(i == R.id.replace_button){
            Toast.makeText(this, "Successfully Replaced Event.", Toast.LENGTH_SHORT).show();
        }if(i == R.id.week_view){
            startActivity(new Intent(this,WeekActivity.class));
        }
    }

    public void displayError(){
        // Create custom dialog object
        final Dialog dialog = new Dialog(CalenderActivity.this);
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

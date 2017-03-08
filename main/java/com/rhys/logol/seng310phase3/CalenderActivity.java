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
    ImageView profilePic;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);

        getSupportActionBar().hide();

        Button settings = (Button) findViewById(R.id.settings);
        Button addEvent = (Button) findViewById(R.id.add_event);
        Button graph = (Button) findViewById(R.id.graph);
        Button displayError = (Button) findViewById(R.id.display_error);

        TextView userID = (TextView) findViewById(R.id.id);

        profilePic = (ImageView) findViewById(R.id.profile_pic);

        userID.setText("UserId");

        settings.setOnClickListener(CalenderActivity.this);
        addEvent.setOnClickListener(CalenderActivity.this);
        graph.setOnClickListener(CalenderActivity.this);
        displayError.setOnClickListener(CalenderActivity.this);
    }

    @Override public void onClick(View view) {
        int i = view.getId();
        if(i == R.id.settings){
            startActivity(new Intent(this,Settings.class));
        }if(i == R.id.add_event){
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

package com.rhys.logol.seng310phase3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mUsernameField;
    private EditText mPasswordField;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().hide();

        mUsernameField = (EditText) findViewById(R.id.username);
        mPasswordField = (EditText) findViewById(R.id.password);

        Button loginButton = (Button) findViewById(R.id.button);
        loginButton.setOnClickListener(this);
    }

    @Override public void onClick(View view) {
        int i  = view.getId();
        if(i == R.id.button){
            if(validateForm()) {
                startActivity(new Intent(this, Notification.class));
                finish();
            }
        }
    }

    private boolean validateForm(){
        boolean validated = true;
        if(TextUtils.isEmpty(mUsernameField.getText().toString())){
            mUsernameField.setError("Required.");
            validated = false;
        }else{
            mUsernameField.setError(null);
        }if(TextUtils.isEmpty(mPasswordField.getText().toString())){
            mPasswordField.setError("Required.");
            validated = false;
        }else{
            mPasswordField.setError(null);
        }
        return validated;
    }
}

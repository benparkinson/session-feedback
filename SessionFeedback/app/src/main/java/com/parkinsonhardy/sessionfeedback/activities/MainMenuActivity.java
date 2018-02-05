package com.parkinsonhardy.sessionfeedback.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.parkinsonhardy.sessionfeedback.R;

public class MainMenuActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        View button1 = findViewById(R.id.session_owner_button);
        button1.setOnClickListener(this);

        View button2 = findViewById(R.id.give_feedback_button);
        button2.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.session_owner_button:
                intent = new Intent(MainMenuActivity.this, SessionOwnerMenuActivity.class);
                break;
            case R.id.give_feedback_button:
                intent = new Intent(MainMenuActivity.this, GiveFeedbackActivity.class);
                break;
        }
        startActivity(intent);
    }
}


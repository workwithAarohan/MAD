package com.academia.layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity
{
    TextView mtxt_login_activity;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mtxt_login_activity = findViewById(R.id.login_link);

        mtxt_login_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent_to_login_activity = new Intent(RegisterActivity.this,
                        MainActivity.class);
                startActivity(intent_to_login_activity);
            }
        });
    }
}
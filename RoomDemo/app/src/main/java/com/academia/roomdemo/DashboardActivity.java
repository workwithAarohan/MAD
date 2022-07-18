package com.academia.roomdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DashboardActivity extends AppCompatActivity {

    TextView mtxt_logout;
    Button mbtn_student;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        mtxt_logout = findViewById(R.id.logout_link);

        SharedPreferences sharedPreferences = getSharedPreferences("credentials",MODE_PRIVATE);

        mtxt_logout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.apply();

                Intent intent_to_main  = new Intent(DashboardActivity.this, MainActivity.class);
                startActivity(intent_to_main);
            }
        });

        mbtn_student = findViewById(R.id.btn_student);

        mbtn_student.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent_to_student = new Intent(DashboardActivity.this, StudentActivity.class);
                startActivity(intent_to_student);
            }
        });
    }
}
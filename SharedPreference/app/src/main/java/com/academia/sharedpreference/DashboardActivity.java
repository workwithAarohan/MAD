package com.academia.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DashboardActivity extends AppCompatActivity {

    Button mbtn_logout;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        mbtn_logout = findViewById(R.id.btn_logout);

        SharedPreferences sharedPreferences = getSharedPreferences("credentials",MODE_PRIVATE);

        mbtn_logout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.apply();

                Intent intent  = new Intent(DashboardActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
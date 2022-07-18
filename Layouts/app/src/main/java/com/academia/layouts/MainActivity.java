package com.academia.layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    TextView mtxt_second_activity;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mtxt_second_activity = findViewById(R.id.btn_register_activity);

        mtxt_second_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent_to_register_activity = new Intent(MainActivity.this,
                        RegisterActivity.class);
                startActivity(intent_to_register_activity);
            }
        });
    }
}
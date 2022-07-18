package com.academia.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{
    Button mbtn_student;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mbtn_student = findViewById(R.id.btn_student);

        mbtn_student.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent_to_view = new Intent(MainActivity.this, ViewActivity.class);
                startActivity(intent_to_view);
            }
        });
    }
}
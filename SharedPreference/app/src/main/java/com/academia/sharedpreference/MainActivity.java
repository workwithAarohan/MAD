package com.academia.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity
{
    TextView mtxt_second_activity, metv_output;
    EditText met_email, met_password;
    Button mbtn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mtxt_second_activity = findViewById(R.id.btn_register_activity);

        mtxt_second_activity.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent_to_register_activity = new Intent(MainActivity.this,
                        RegisterActivity.class);
                startActivity(intent_to_register_activity);
            }
        });

        met_email = findViewById(R.id.et_email);
        met_password = findViewById(R.id.et_password);
        mbtn_login = findViewById(R.id.btn_login);
        metv_output = findViewById(R.id.tv_output);

        checkSharedPreference();

        mbtn_login.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String email = met_email.getText().toString();
                String password = met_password.getText().toString();

                if(email.equals("aarohan@gmail.com") && password.equals("password"))
                {
                    String lowerAlphabet ="abcdefghijklmnopqrstuvwxyz";
                    StringBuilder sb = new StringBuilder();
                    Random random = new Random();
                    int length = 20;
                    int index;
                    char randomChar;

                    for(int i = 0; i < length; i++)
                    {
                        index = random.nextInt(lowerAlphabet.length());
                        randomChar = lowerAlphabet.charAt(index);
                        sb.append(randomChar);
                    }

                    String token = sb.toString();
                    System.out.println("Random String is: " + token);

                    SharedPreferences sharedPreferences = getSharedPreferences("credentials", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("email", met_email.getText().toString());
                    editor.putString("token", token);
                    editor.apply();

                    Intent intent = new Intent(MainActivity.this, DashboardActivity.class);
                    startActivity(intent);
                }
                else
                {
                    metv_output.setText("Email or password is not correct.");
                    metv_output.setTextColor(Color.RED);
                }
            }
        });

    }

    private void checkSharedPreference()
    {
        SharedPreferences sharedPreferences = getSharedPreferences("credentials", MODE_PRIVATE);

        if(sharedPreferences.contains("token"))
        {
            Intent intent = new Intent(MainActivity.this, DashboardActivity.class);
            startActivity(intent);
        }
        else
        {
            metv_output.setText(" ");
            metv_output.setText("Enter email and password to continue session.");
        }
    }

}
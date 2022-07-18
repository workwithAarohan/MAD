package com.academia.roomdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.academia.roomdemo.Dao.StudentDao;
import com.academia.roomdemo.Database.StudentRoomDatabase;
import com.academia.roomdemo.Model.Student;

public class CreateStudentActivity extends AppCompatActivity
{
    EditText met_roll_no, met_first_name, met_last_name;
    Button mbtn_save;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_student);

        met_roll_no = findViewById(R.id.et_roll_no);
        met_first_name = findViewById(R.id.et_first_name);
        met_last_name = findViewById(R.id.et_last_name);

        mbtn_save = findViewById(R.id.btn_save);

        StudentRoomDatabase db = StudentRoomDatabase.getDatabase(getApplicationContext());

        mbtn_save.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                StudentDao studentDao = db.studentDao();
                studentDao.insertAll(new Student(met_roll_no.getText().toString(),
                                    met_first_name.getText().toString(),
                                    met_last_name.getText().toString()));
                Intent intent_to_student = new Intent(CreateStudentActivity.this,
                                    StudentActivity.class);
                startActivity(intent_to_student);
            }
        });
    }
}
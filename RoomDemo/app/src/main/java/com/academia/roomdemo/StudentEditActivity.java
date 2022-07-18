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

public class StudentEditActivity extends AppCompatActivity
{
    EditText met_roll_no, met_first_name, met_last_name;
    Button mbtn_save;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_edit);

        met_roll_no = findViewById(R.id.et_roll_no);
        met_first_name = findViewById(R.id.et_first_name);
        met_last_name = findViewById(R.id.et_last_name);

        int uid = getIntent().getIntExtra("uid", 1);

        StudentRoomDatabase db = StudentRoomDatabase.getDatabase(getApplicationContext());
        StudentDao studentDao = db.studentDao();

        Student student = studentDao.getById(uid);

        met_roll_no.setText(student.getRollNo());
        met_first_name.setText(student.getFirstName());
        met_last_name.setText(student.getLastName());

        mbtn_save = findViewById(R.id.btn_save);

        mbtn_save.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                student.setRollNo(met_roll_no.getText().toString());
                student.setFirstName(met_first_name.getText().toString());
                student.setLastName(met_last_name.getText().toString());

                studentDao.updateStudent(student);

                Intent intent_to_show = new Intent(StudentEditActivity.this,
                        StudentShowActivity.class);
                intent_to_show.putExtra("uid", uid);
                startActivity(intent_to_show);

            }
        });

    }
}
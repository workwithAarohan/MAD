package com.academia.roomdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.academia.roomdemo.Dao.StudentDao;
import com.academia.roomdemo.Database.StudentRoomDatabase;
import com.academia.roomdemo.Model.Student;

import java.util.List;

public class StudentShowActivity extends AppCompatActivity
{
    TextView mtxt_roll_no, mtxt_first_name, mtxt_last_name;
    Button mbtn_edit, mbtn_delete;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_show);

        int uid = getIntent().getIntExtra("uid", 1);

        getStudentById(uid);

        mbtn_delete = findViewById(R.id.btn_delete);
        mbtn_delete.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                StudentRoomDatabase db = StudentRoomDatabase.getDatabase(getApplicationContext());
                StudentDao studentDao = db.studentDao();

                Student student = studentDao.getById(uid);

                studentDao.deleteStudent(student);

                Intent intent_to_student_list = new Intent(StudentShowActivity.this,
                                StudentActivity.class);

                startActivity(intent_to_student_list);
            }
        });

        mbtn_edit = findViewById(R.id.btn_edit);
        mbtn_edit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent_to_student_edit = new Intent(StudentShowActivity.this,
                        StudentEditActivity.class);
                intent_to_student_edit.putExtra("uid", uid);
                startActivity(intent_to_student_edit);
            }
        });


    }

    private void getStudentById(int uid)
    {
        StudentRoomDatabase db = StudentRoomDatabase.getDatabase(getApplicationContext());
        StudentDao studentDao = db.studentDao();

        Student student = studentDao.getById(uid);

        mtxt_roll_no = findViewById(R.id.txt_roll_no);
        mtxt_first_name = findViewById(R.id.txt_first_name);
        mtxt_last_name = findViewById(R.id.txt_last_name);

        mtxt_roll_no.setText(student.getRollNo());
        mtxt_first_name.setText(student.getFirstName());
        mtxt_last_name.setText(student.getLastName());
    }
}
package com.academia.roomdemo;

import android.content.Intent;
import android.os.Bundle;

import com.academia.roomdemo.Adapter.StudentAdapter;
import com.academia.roomdemo.Dao.StudentDao;
import com.academia.roomdemo.Database.StudentRoomDatabase;
import com.academia.roomdemo.Model.Student;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.academia.roomdemo.databinding.ActivityStudentBinding;

import java.util.List;

public class StudentActivity extends AppCompatActivity
{

    private AppBarConfiguration appBarConfiguration;
    private ActivityStudentBinding binding;
    RecyclerView mrv_student;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        binding = ActivityStudentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        binding.fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent_to_student_list = new Intent(StudentActivity.this,
                                        CreateStudentActivity.class);
                startActivity(intent_to_student_list);
            }
        });

        getStudentData();
    }

    private void getStudentData()
    {
        StudentRoomDatabase db = StudentRoomDatabase.getDatabase(getApplicationContext());
        StudentDao studentDao = db.studentDao();

        mrv_student = findViewById(R.id.rv_student);
        mrv_student.setLayoutManager(new LinearLayoutManager(this));

        List<Student> students = studentDao.getAll();
        Log.d("students", students.toString());
        StudentAdapter studentAdapter = new StudentAdapter(this, students);
        mrv_student.setAdapter(studentAdapter);

    }
}
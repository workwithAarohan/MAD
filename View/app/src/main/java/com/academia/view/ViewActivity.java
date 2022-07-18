package com.academia.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.academia.view.Adapter.StudentAdapter;
import com.academia.view.Model.Student;

import java.util.ArrayList;

public class ViewActivity extends AppCompatActivity
{
    RecyclerView mrv_student;

    ArrayList<Student> studentArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        mrv_student = findViewById(R.id.rv_student);

        // Set Layout Manager
        mrv_student.setLayoutManager(new LinearLayoutManager(this));

        studentArrayList.add(new Student("15821", "Aarohan", "Nakarmi"));
        studentArrayList.add(new Student("15822", "Arz", "Nry"));
        studentArrayList.add(new Student("15823", "Ram", "Bahadur"));
        studentArrayList.add(new Student("15824", "Shyam", "Bahadur"));
        studentArrayList.add(new Student("15825", "Hari", "Bahadur"));
        studentArrayList.add(new Student("15826", "Krishna", "Bahadur"));
        studentArrayList.add(new Student("15827", "Shiva", "Narayan"));
        studentArrayList.add(new Student("15828", "Aarohan", "Nakarmi"));
        studentArrayList.add(new Student("15829", "Aarohan", "Nakarmi"));

        StudentAdapter adapter = new StudentAdapter(this, studentArrayList);

        mrv_student.setAdapter(adapter);
    }
}
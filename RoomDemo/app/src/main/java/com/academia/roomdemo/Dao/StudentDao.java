package com.academia.roomdemo.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.academia.roomdemo.Model.Student;

import java.util.List;

@Dao
public interface StudentDao
{
    @Query("SELECT * FROM student")
    List<Student> getAll();

    @Insert
    void insertAll(Student student);

    @Query("SELECT * FROM student WHERE uid = (:studentId)")
    Student getById(int studentId);

    @Update
    void updateStudent(Student student);

    @Delete
    void deleteStudent(Student student);
}

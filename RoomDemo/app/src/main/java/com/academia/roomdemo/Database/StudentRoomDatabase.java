package com.academia.roomdemo.Database;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.academia.roomdemo.Dao.StudentDao;
import com.academia.roomdemo.Model.Student;

@Database(entities = {Student.class}, version = 1)
public abstract class StudentRoomDatabase extends RoomDatabase
{
    private static StudentRoomDatabase studentRoomDatabase;

    public static StudentRoomDatabase getDatabase(final Context context)
    {
        if(studentRoomDatabase == null)
        {
            synchronized (StudentRoomDatabase.class)
            {
                if(studentRoomDatabase == null)
                {
                    studentRoomDatabase = Room.databaseBuilder(context.getApplicationContext(),
                                StudentRoomDatabase.class,
                                "student_database")
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return studentRoomDatabase;
    }


    public abstract StudentDao studentDao();
}
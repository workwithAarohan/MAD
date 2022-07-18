package com.academia.roomdemo.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.academia.roomdemo.Model.Student;
import com.academia.roomdemo.R;
import com.academia.roomdemo.StudentShowActivity;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder>
{
    Context context;
    private List<Student> studentList;

    public StudentAdapter(Context context, List<Student> studentList)
    {
        this.context = context;
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_student, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        Student student = studentList.get(position);

        holder.mtv_roll_no.setText(studentList.get(position).getRollNo());
        holder.mtv_first_name.setText(studentList.get(position).getFirstName());
        holder.mtv_last_name.setText(studentList.get(position).getLastName());

        holder.mtv_roll_no.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent_to_show = new Intent(context, StudentShowActivity.class);
                intent_to_show.putExtra("uid", student.getUid());
//                intent_to_show.putExtra("first_name", student.getFirstName());
//                intent_to_show.putExtra("last_name", student.getLastName());
                context.startActivity(intent_to_show);
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return studentList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView mtv_roll_no, mtv_first_name, mtv_last_name;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            mtv_roll_no = itemView.findViewById(R.id.txt_roll_no);
            mtv_first_name = itemView.findViewById(R.id.txt_first_name);
            mtv_last_name = itemView.findViewById(R.id.txt_last_name);
        }
    }
}

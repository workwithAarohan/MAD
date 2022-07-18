package com.academia.view.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.academia.view.Model.Student;
import com.academia.view.R;

import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder>
{
    Context context;
    ArrayList<Student> studentArrayList = new ArrayList<>();

    public StudentAdapter(Context context, ArrayList<Student> studentArrayList)
    {
        this.context = context;
        this.studentArrayList = studentArrayList;
    }

    @NonNull
    @Override
    public StudentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.row_student, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StudentAdapter.ViewHolder holder, int position)
    {
        holder.mtv_roll_no.setText(studentArrayList.get(position).getRoll_no());
        holder.mtv_first_name.setText(studentArrayList.get(position).getFirst_name());
        holder.mtv_last_name.setText(studentArrayList.get(position).getLast_name());
    }

    @Override
    public int getItemCount()
    {
        return studentArrayList.size();
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

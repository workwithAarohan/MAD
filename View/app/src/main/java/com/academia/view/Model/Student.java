package com.academia.view.Model;

public class Student
{
    String roll_no, first_name, last_name;

    public Student(String roll_no, String first_name, String last_name)
    {
        this.roll_no = roll_no;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public String getRoll_no()
    {
        return roll_no;
    }

    public void setRoll_no(String roll_no)
    {
        this.roll_no = roll_no;
    }

    public String getFirst_name()
    {
        return first_name;
    }

    public void setFirst_name(String first_name)
    {
        this.first_name = first_name;
    }

    public String getLast_name()
    {
        return last_name;
    }

    public void setLast_name(String last_name)
    {
        this.last_name = last_name;
    }
}

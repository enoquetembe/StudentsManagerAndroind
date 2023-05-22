package com.example.studentsmanagerandroind;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentAdapter extends BaseAdapter {

    ArrayList<Student> students = new ArrayList<>();
    Context context;
    LayoutInflater inflater;

    public StudentAdapter(ArrayList<Student> students, Context context) {
        this.students = students;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return students.size();
    }

    @Override
    public Object getItem(int position) {
        return students.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.list_student_item, null);
        TextView textView_name = convertView.findViewById(R.id.textView_nome);

        textView_name.setText(students.get(position).getName());
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent para abrir a StudentDetailsActivity
                Intent intent = new Intent(context, StudentDatailsActivity.class);
                intent.putExtra("id", students.get(position).getId());
                intent.putExtra("name", students.get(position).getName());
                intent.putExtra("age", students.get(position).getAge());
                intent.putExtra("sex", students.get(position).getGender());
                intent.putExtra("address", students.get(position).getAddress());
                intent.putExtra("tel", students.get(position).getTel());
                context.startActivity(intent);

                }});

        return convertView;
    }
}

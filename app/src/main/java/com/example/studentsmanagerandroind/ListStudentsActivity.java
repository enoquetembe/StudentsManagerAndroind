package com.example.studentsmanagerandroind;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.studentsmanagerandroind.databinding.ActivityListStudentsBinding;

import java.util.ArrayList;

public class ListStudentsActivity extends AppCompatActivity {

    ActivityListStudentsBinding binding;
    ArrayList<Student> students;
    private DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListStudentsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        databaseHelper = new DatabaseHelper(this);

        students = databaseHelper.getAllStudents();

        StudentAdapter adapter = new StudentAdapter( students, this);
        binding.lvStudents.setAdapter(adapter);


    }
}
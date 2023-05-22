package com.example.studentsmanagerandroind;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.studentsmanagerandroind.databinding.ActivityStudentDatailsBinding;

public class StudentDatailsActivity extends AppCompatActivity {

    private ActivityStudentDatailsBinding binding;
    private String studentName;
    private DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStudentDatailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        databaseHelper = new DatabaseHelper(this);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        studentName = name;
        int age = intent.getIntExtra("age", 0);
        String sex = intent.getStringExtra("sex");
        String address = intent.getStringExtra("address");
        String telefone = intent.getStringExtra("tel");

        binding.tvDName.setText(name);
        binding.tvDge.setText(String.valueOf(age));
        binding.tvDSex.setText(sex);
        binding.tvDAddress.setText(address);
        binding.ttvDTel.setText(telefone);

         binding.btnDelete.setOnClickListener(v -> {
                deleteStudent();
         });
    }

    private void deleteStudent() {
        System.out.println(studentName);
        databaseHelper.delete(studentName);

        this.finish();
    }
}
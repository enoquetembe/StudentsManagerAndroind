package com.example.studentsmanagerandroind;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.studentsmanagerandroind.databinding.ActivityStudentDatailsBinding;

public class StudentDatailsActivity extends AppCompatActivity {

    private ActivityStudentDatailsBinding binding;
    private String studentName;

    Student student;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStudentDatailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        databaseHelper = new DatabaseHelper(this);
        new Student();
        binding.etDId.setEnabled(false);
        binding.etDName.setEnabled(false);
        binding.etDAge.setEnabled(false);;
        binding.etDSex.setEnabled(false);;
        binding.etDAdress.setEnabled(false);
        binding.etDTel.setEnabled(false);

        Intent intent = getIntent();

        int id = intent.getIntExtra("id", 0);
        String name = intent.getStringExtra("name");
        studentName = name;
        int age = intent.getIntExtra("age", 0);
        String sex = intent.getStringExtra("sex");
        String address = intent.getStringExtra("address");
        int tel = intent.getIntExtra("tel", 0);


        binding.etDId.setText(String.valueOf(id));
        binding.etDName.setText(name);
        binding.etDAge.setText(String.valueOf(age));
        binding.etDSex.setText(sex);
        binding.etDAdress.setText(address);
        binding.etDTel.setText(String.valueOf(tel));


         binding.btnDelete.setOnClickListener(v -> {
                deleteStudent();
         });

        binding.btnUpdate.setOnClickListener(v -> {
            binding.etDName.setEnabled(true);
            binding.etDAge.setEnabled(true);;
            binding.etDSex.setEnabled(true);;
            binding.etDAdress.setEnabled(true);
            binding.etDTel.setEnabled(true);

            binding.btnUpdate.setClickable(false);
        });

        binding.btnDSave.setOnClickListener(v -> {
            updateStudent();
        });

    }

    private void deleteStudent() {
        System.out.println(studentName);
        databaseHelper.delete(studentName);

        this.finish();
    }


    private void updateStudent() {
        int id = Integer.parseInt(binding.etDId.getText().toString().trim());
        String name = binding.etDName.getText().toString().trim();
        int age = Integer.parseInt(binding.etDAge.getText().toString().trim());
        String sex = binding.etDSex.getText().toString().trim();
        String address = binding.etDAdress.getText().toString().trim();
        int telefone = Integer.parseInt(binding.etDTel.getText().toString().trim());

        databaseHelper.update(id, name, age, sex, address, telefone);

        Toast.makeText(this, "Estudante atualizado com sucesso", Toast.LENGTH_SHORT).show();
        finish();
    }


}
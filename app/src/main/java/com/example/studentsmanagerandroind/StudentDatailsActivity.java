package com.example.studentsmanagerandroind;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

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

        binding.etDName.setEnabled(false);
        binding.etDge.setEnabled(false);;
        binding.etDSex.setEnabled(false);;
        binding.etDAddress.setEnabled(false);
        binding.etDTel.setEnabled(false);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        studentName = name;
        int age = intent.getIntExtra("age", 0);
        String sex = intent.getStringExtra("sex");
        String address = intent.getStringExtra("address");
        String telefone = intent.getStringExtra("tel");

        binding.etDName.setText(name);
        binding.etDge.setText(String.valueOf(age));
        binding.etDSex.setText(sex);
        binding.etDAddress.setText(address);
        binding.etDTel.setText(telefone);



         binding.btnDelete.setOnClickListener(v -> {
                deleteStudent();
         });

        binding.btnUpdate.setOnClickListener(v -> {
            binding.etDName.setEnabled(true);
            binding.etDge.setEnabled(true);;
            binding.etDSex.setEnabled(true);;
            binding.etDAddress.setEnabled(true);
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
        String name = binding.etDName.getText().toString();
        int age = Integer.parseInt(binding.etDge.getText().toString());
        String gender = binding.etDSex.getText().toString();
        String address = binding.etDAddress.getText().toString();
        String telefone = binding.etDTel.getText().toString();

        databaseHelper.update(name, age, gender, address, telefone);

        Toast.makeText(this, "Estudante atualizado com sucesso", Toast.LENGTH_SHORT).show();
    }

}
package com.example.studentsmanagerandroind;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.studentsmanagerandroind.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnSave.setOnClickListener( v -> {
            saveStudent();
        });



    }

    public  void saveStudent() {
        String name = binding.txtName.getText().toString();
        int age = Integer.parseInt( binding.txtAge.getText().toString());
        String adress =  binding.txtAdress.getText().toString();
        String telefone =  binding.txtTel.getText().toString();

        int radioButtonId =  binding.radioGroupSexo.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(radioButtonId);
        String gender = radioButton.getText().toString();

        databaseHelper.save(name, age, gender, adress, telefone);

        Toast.makeText(this, "Aluno salvo com sucesso!", Toast.LENGTH_SHORT).show();
    }
}
package com.example.sqlite_f55121029;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.sqlite_f55121029.databinding.ActivityRegisterBinding;
import com.example.sqlite_f55121029.utlis.DatabaseHelper;

public class RegisterActivity extends AppCompatActivity {

    private ActivityRegisterBinding binding;

    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        databaseHelper = new DatabaseHelper(this);

        binding.btnLogin.setOnClickListener(view -> {
            String username = binding.edtUsername.getText().toString().trim();
            String password = binding.edtPassword.getText().toString().trim();
            String confPass = binding.edtConfirm.getText().toString().trim();

            if (password.equals(confPass)) {
                long val = databaseHelper.addUser(username, password);
                if (val > 0) {
                    Toast.makeText(RegisterActivity.this, "You have register",
                            Toast.LENGTH_SHORT).show();
                    Intent moveToLogin = new
                            Intent(RegisterActivity.this, MainActivity.class);
                    startActivity(moveToLogin);
                }
            } else {

                Toast.makeText(RegisterActivity.this,"Password is not Matching",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
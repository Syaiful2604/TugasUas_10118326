package com.example.uts_10118326_if8;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txtuname, txtpass;
    private Button btnlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtuname = findViewById(R.id.txtuname);
        txtpass = findViewById(R.id.txtpass);
        btnlogin = findViewById(R.id.btnlogin);

        btnlogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String inputName = txtuname.getText().toString();
                String inputPassword = txtpass.getText().toString();
                if(inputName.equals("admin") && inputPassword.equals("admin")){
                    //Login Berhasil
                    Toast.makeText(getApplicationContext(), "Login Berhasil", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, home.class);
                    MainActivity.this.startActivity(intent);
                    finish();
                }else{
                    //Login Gagal
                    Toast.makeText(getApplicationContext(), "Login Gagal", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

// tanggal pengerjaan : 6 juni 2021
// nim : 10118326
// nama : Syaiful Bahri
// kelas : IF-8
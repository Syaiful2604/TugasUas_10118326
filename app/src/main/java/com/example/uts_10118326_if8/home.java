package com.example.uts_10118326_if8;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class home extends AppCompatActivity {
    Database dbku;

    EditText edittanggal, editjudul, editkategori, editisi;

    Button btnAdd, btnUpdate, btnDelete, btnView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        dbku = new Database(this);

        edittanggal = (EditText)findViewById(R.id.txttanggal);

        editjudul = (EditText)findViewById(R.id.txtjudul);

        editkategori = (EditText)findViewById(R.id.txtkategori);

        editisi = (EditText)findViewById(R.id.txtisi);

        btnAdd = (Button)findViewById(R.id.btnsimpan);

        btnUpdate = (Button)findViewById(R.id.btnedit);

        btnDelete = (Button)findViewById(R.id.btnhapus);

        btnView = (Button)findViewById(R.id.btntampil);

        Add();
        View();
        Update();
        Delete();
    }

    public void Add() {

        btnAdd.setOnClickListener(

                new View.OnClickListener() {

                    @Override

                    public void onClick(View v) {

                        boolean isInserted = dbku.tambahData(edittanggal.getText().toString(),

                                editjudul.getText().toString(),

                                editkategori.getText().toString(),

                                editisi.getText().toString() );

                        if(isInserted == true)

                            Toast.makeText(home.this,"Data Berhasil Disimpan",Toast.LENGTH_LONG).show();

                        else

                            Toast.makeText(home.this,"Data Tidak Berhasil Disimpan",Toast.LENGTH_LONG).show();

                    }

                }

        );

    }

    public void Update() {

        btnUpdate.setOnClickListener(

                new View.OnClickListener() {

                    @Override

                    public void onClick(View v) {

                        boolean isUpdate = dbku.updateData(edittanggal.getText().toString(),

                                editjudul.getText().toString(),

                                editkategori.getText().toString(),

                                editisi.getText().toString());

                        if(isUpdate == true)

                            Toast.makeText(home.this,"Data Berhasil Diperbaharui",Toast.LENGTH_LONG).show();

                        else

                            Toast.makeText(home.this,"Data Tidak Berhasil Diperbaharui",Toast.LENGTH_LONG).show();

                    }

                }

        );

    }

    public void Delete() {

        btnDelete.setOnClickListener(

                new View.OnClickListener() {

                    @Override

                    public void onClick(View v) {

                        Integer deletedRows = dbku.deleteData(edittanggal.getText().toString());

                        if (deletedRows > 0)

                            Toast.makeText(home.this,"Data Berhasil Dihapus",Toast.LENGTH_LONG).show();

                        else

                            Toast.makeText(home.this,"Data Tidak Berhasil Dihapus",Toast.LENGTH_LONG).show();

                    }

                }

        );

    }

    public void View() {

        btnView.setOnClickListener(

                new View.OnClickListener(){

                    @Override

                    public void onClick(View v) {

                        Cursor res = dbku.tampildata();

                        if(res.getCount() == 0) {

                            // show message

                            showMessage("Error","Noting Found");

                            return;

                        }



                        StringBuffer buffer = new StringBuffer();

                        while (res.moveToNext() ) {

                            buffer.append("Tanggal   : "+ res.getString(0)+"\n");

                            buffer.append("Judul  : "+ res.getString(1)+"\n");

                            buffer.append("Kategori : "+ res.getString(2)+"\n");

                            buffer.append("Isi : "+ res.getString(3)+"\n\n");

                        }



                        // show all data

                        showMessage("Data",buffer.toString());

                    }

                }

        );

    }

    public void showMessage(String title, String Message){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setCancelable(true);

        builder.setTitle(title);

        builder.setMessage(Message);

        builder.show();

    }
}

// tanggal pengerjaan : 6 juni 2021
// nim : 10118326
// nama : Syaiful Bahri
// kelas : IF-8
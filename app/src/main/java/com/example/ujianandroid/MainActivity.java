package com.example.ujianandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edNamaDepan = (EditText) findViewById(R.id.edNamaDepan);
        EditText edNamaBelakang = (EditText) findViewById(R.id.edNamaBelakang);
        EditText edUmur = (EditText) findViewById(R.id.edUmur);
        Button btnSimpan = (Button) findViewById(R.id.btnSimpan);

        ArrayList<String> daftar_nama = new ArrayList<>();

        Intent intent_list = new Intent(MainActivity.this, ListActivity.class);
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String isian_nama_depan = edNamaDepan.getText().toString();
                String isian_nama_belakang = edNamaBelakang.getText().toString();
                String isian_umur = edUmur.getText().toString(); // Tambahkan input umur

                if(isian_nama_depan.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Isian masih kosong", Toast.LENGTH_SHORT).show();
                } else if (isian_umur.isEmpty()) { // Periksa apakah input umur kosong
                    Toast.makeText(getApplicationContext(), "Umur belum diisi", Toast.LENGTH_SHORT).show();
                } else {
                    int jumlah_umur = Integer.parseInt(isian_umur); // Konversi input umur menjadi integer
                    String nama_lengkap = isian_nama_depan.concat(" ").concat(isian_nama_belakang);
                    daftar_nama.clear();

                    for (int i = 0; i < jumlah_umur; i++) {
                        daftar_nama.add(nama_lengkap);
                    }

                    edNamaDepan.setText("");
                    edNamaBelakang.setText("");
                    intent_list.putStringArrayListExtra("daftar_nama", daftar_nama);

                    // Cetak nama sebanyak jumlah umur
                    for (String nama : daftar_nama) {
                        System.out.println(nama);
                    }

                    startActivity(intent_list);
                }
            }
        });
    }
}
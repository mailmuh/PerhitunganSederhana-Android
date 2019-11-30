package com.nobody.androiddasar2userinput;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edSisi;
    Button btnHitung;
    TextView tvhasil;
    Spinner spinnerPilihan;
    String[] pilihanHitung = {"Volume", "Keliling", "Luas Permukaan"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edSisi = findViewById(R.id.ed_sisi);
        btnHitung = findViewById(R.id.btn_hitung);
        tvhasil = findViewById(R.id.tv_hasil);
        spinnerPilihan = findViewById(R.id.spinner_pilihan);

        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (spinnerPilihan.getSelectedItem().toString().equals(pilihanHitung[0])) {
                    //rumus Volume
                    rumusVolume();
                }else if (spinnerPilihan.getSelectedItem().toString().equals(pilihanHitung[1])) {
                    //rumus Keliling
                    Double sisi = Double.valueOf(edSisi.getText().toString());
                    rumusKeliling(sisi);
                }else if (spinnerPilihan.getSelectedItem().toString().equals(pilihanHitung[2])) {
                    //rumus luas permukaan
                    Double hasil = rumusLuasPermukaan();
                    tvhasil.setText(hasil.toString());
                }

            }
        });

        //data
        //adapter
        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, pilihanHitung);
        spinnerPilihan.setAdapter(adapter);
    }

    private Double rumusLuasPermukaan() {
        Double sisi = Double.valueOf(edSisi.getText().toString());
        Double hasil = 12 * sisi;
        return hasil;
    }

    private void rumusKeliling(Double sisi) {
        Double hasil = 6 * sisi * sisi;
        tvhasil.setText(hasil.toString());
    }

    private void rumusVolume() {
        Double sisi = Double.valueOf(edSisi.getText().toString());
        Double hasil = sisi * sisi * sisi;
        tvhasil.setText(hasil.toString());
    }
}

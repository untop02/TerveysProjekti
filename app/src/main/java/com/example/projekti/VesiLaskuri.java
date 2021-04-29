package com.example.projekti;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class VesiLaskuri extends AppCompatActivity {

    double vesimaara;
    TextView vedenmaara;
    Button pienipullo;
    Button isopullo;
    Button vesilasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vesi_laskuri);

        vedenmaara = findViewById(R.id.juotuMaara);
        vesilasi = findViewById(R.id.lasiBtn);
        isopullo = findViewById(R.id.isopulloBtn);
        pienipullo = findViewById(R.id.pienipulloBtn);

        vesilasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lisaaLasi();
            }
        });
        pienipullo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lisaapienipullo();
            }
        });
        isopullo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lisaaisopullo();
            }
        });
    }
    public void lisaaLasi(){
        vesimaara += 0.3;
        vedenmaara.setText(String.valueOf(vesimaara));
    }
    public void lisaapienipullo(){
        vesimaara += 0.5;
        vedenmaara.setText(String.valueOf(vesimaara));
    }
    public void lisaaisopullo(){
        vesimaara += 1.5;
        vedenmaara.setText(String.valueOf(vesimaara));
    }

}
package com.example.projekti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button painoIndeksiBtn = (Button)findViewById(R.id.PainoIndeksiBtn);
        Button verenpaineBtn = (Button)findViewById(R.id.VerenpaineBtn);
        Button vesilaskuriBtn = (Button)findViewById(R.id.VesiLaskuriBtn);

        verenpaineBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Verenpaine.class));
            }
        });

        painoIndeksiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PainoIndeksi.class));
            }
        });
        vesilaskuriBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, VesiLaskuri.class));
            }
        });


    }
}
package com.example.projekti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton painoIndeksiBtn = (ImageButton )findViewById(R.id.PainoIndeksiBtn);
        ImageButton  verenpaineBtn = (ImageButton )findViewById(R.id.VerenpaineBtn);
        ImageButton  vesilaskuriBtn = (ImageButton )findViewById(R.id.VesiLaskuriBtn);

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
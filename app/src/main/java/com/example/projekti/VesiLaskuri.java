package com.example.projekti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Context;

public class VesiLaskuri extends AppCompatActivity {

    Double vesimaara = 0.0;
    TextView vedenmaara;
    Button pienipullo;
    Button isopullo;
    Button vesilasi;
    Button nollaa;
    int resetointi = 0;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String vesitalletus = "vesiavain";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vesi_laskuri);



        vedenmaara = findViewById(R.id.juotuMaara);
        vesilasi = findViewById(R.id.lasiBtn);
        isopullo = findViewById(R.id.isopulloBtn);
        pienipullo = findViewById(R.id.pienipulloBtn);
        nollaa = findViewById(R.id.resetBtn);

        nollaa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
            }

        });
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
    public void reset(){
        vesimaara = 0.0;
        TextView vedenmaara = findViewById(R.id.juotuMaara);
        vedenmaara.setText("0.0");
    }
    public void lisaaLasi(){
        vesimaara += 0.3;
        double roundOff = Math.round(vesimaara * 100.0) / 100.0;
        vedenmaara.setText(String.valueOf(roundOff));
    }
    public void lisaapienipullo(){
        vesimaara += 0.5;
        double roundOff = Math.round(vesimaara * 100.0) / 100.0;
        vedenmaara.setText(String.valueOf(roundOff));
    }
    public void lisaaisopullo(){
        vesimaara += 1.5;
        double roundOff = Math.round(vesimaara * 100.0) / 100.0;
        vedenmaara.setText(String.valueOf(roundOff));
    }
    @Override
    protected void onStart() {
        super.onStart();
        loadData();
    }
    @Override
    protected void onPause() {
        super.onPause();
        talletus();
    }
    public void talletus(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(vesitalletus, vedenmaara.getText().toString());
        editor.apply();
    }
    public void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        String text = sharedPreferences.getString(vesitalletus, "");
        TextView vedenmaara = findViewById(R.id.juotuMaara);
        vedenmaara.setText(text);
    }
}
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

        //nappula joka lisää tietyn määrän vettä
        nollaa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
            }
        });
        //nappula joka lisää tietyn määrän vettä
        vesilasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lisaaLasi();
            }
        });
        //lisää tietyn määrän vettä
        pienipullo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lisaapienipullo();
            }
        });
        //nappula joka lisää tietyn määrän vettä
        isopullo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lisaaisopullo();
            }
        });
    }
    //resetointi metodi
    public void reset(){
        vesimaara = 0.0;
        TextView vedenmaara = findViewById(R.id.juotuMaara);
        vedenmaara.setText("0.0");
    }
    //Metodi jonka kutsuessa lisää tietyn määrän vettä
    public void lisaaLasi(){
        vesimaara += 0.3;
        double roundOff = Math.round(vesimaara * 100.0) / 100.0;
        vedenmaara.setText(String.valueOf(roundOff));
    }
    //Metodi jonka kutsuessa lisää tietyn määrän vettä
    public void lisaapienipullo(){
        vesimaara += 0.5;
        double roundOff = Math.round(vesimaara * 100.0) / 100.0;
        vedenmaara.setText(String.valueOf(roundOff));
    }
    //Metodi jonka kutsuessa lisää tietyn määrän vettä
    public void lisaaisopullo(){
        vesimaara += 1.5;
        double roundOff = Math.round(vesimaara * 100.0) / 100.0;
        vedenmaara.setText(String.valueOf(roundOff));
    }
    //kutsuu käynnistyksen kohdalla loadDataa
    @Override
    protected void onStart() {
        super.onStart();
        loadData();
    }
    //käyttäjän poistuessa sovelluksesta kutsuu talletusta
    @Override
    protected void onPause() {
        super.onPause();
        talletus();
    }
    //tallentaa tiedot
    public void talletus(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(vesitalletus, vedenmaara.getText().toString());
        editor.apply();
    }
    //lataa tiedot
    public void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        String text = sharedPreferences.getString(vesitalletus, "");
        TextView vedenmaara = findViewById(R.id.juotuMaara);
        vedenmaara.setText(text);
    }
}